import os.path
import logging
import json
import sys

EN_GB = "en_GB"
DE_DE = "de_DE"

"""Migrates txt vocabulary files to json

Migrates txt vocabulary field to json, so It is easier to insert into db using mongo. It parses lines that have the following format:

<<word>> | <<word in english>> [| <<example>> ]

So, we can see that example section is optional (that why it is on [] ).

Also, lines that starts with # are ignored. That is to allow you to make comments in the file.
"""
def migrate_txt_to_json(file_path, target_directory, deck_name, deck_type = "phrases"):
    # TODO by default, it looks for source_filename in public/data folder
    # TODO target_directory is optional, if not specified it targets to current directory
    # TODO add explanation of different parameters in the python doc comment and in readme
    # TODO validate file_path is .txt
    if not file_path:
        # TODO improve this log message
        logger.info("please provide file path")
        return

    if not file_path:
        logger.info("file not found")
        return

    language = get_language(file_path)

    flashcard_list = []

    with open(file_path, 'r') as file:
        for line in file:
            if not empty_or_comment(line):
                flashcard = parse_flashcard_line(line)
                if flashcard is not None:
                    flashcard_list.append(flashcard)

    if len(flashcard_list) == 0:
        return

    deck = create_deck(deck_name, deck_type, language, flashcard_list)

    destiny_filename = get_destiny_filename(file_path)
    destiny_path = os.path.join(target_directory, destiny_filename)

    with open(destiny_path, "w", encoding = "utf8") as output_file:
        json.dump(deck, output_file, ensure_ascii = False, indent = 2)

def get_destiny_filename(file_path):
    return f'{extract_file_name_with_extension(file_path)}.json'

def extract_file_name_with_extension(file_path):
    filename = file_path.split(os.sep)[-1]
    idx_dot = filename.rfind(".")
    return filename[:idx_dot]


def create_deck(name, deck_type, language, flashcard_list):
    deck = {}
    deck["name"] = name
    deck["type"] = deck_type
    deck["language"] = language
    deck["tags"] = []
    deck["flashcards"] = flashcard_list
    return deck

def parse_flashcard_line(line):
    chunks = line.split("|")
    if len(chunks) < 2:
        return None

    front = chunks[0].strip()
    back = chunks[1].strip()

    flashcard = {}
    flashcard["front"] = front
    flashcard["back"] = back

    if len(chunks) > 2:
        flashcard["example"] = chunks[2].strip()

    return flashcard

def get_language(filename):
    return EN_GB if ".en" in filename else DE_DE

def empty_or_comment(line):
    return not line or line[0] == '#'

if __name__ == "__main__":
    args = sys.argv
    # TODO add command check / arguments number validation
    migrate_txt_to_json(args[1], args[2], args[3])