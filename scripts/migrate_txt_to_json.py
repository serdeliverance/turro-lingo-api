import os.path
import logging

EN_GB = "en_GB"
DE_DE = "de_DE"

PUBLIC_DATA_FOLDER = "ui/public/data"
"""Migrates txt vocabulary files to json

Migrates txt vocabulary field to json, so It is easier to insert into db using mongo. It parses lines that have the following format:

<<word>> | <<word in english>> [| <<example>> ]

So, we can see that example section is optional (that why it is on [] ).

Also, lines that starts with # are ignored. That is to allow you to make comments in the file.
"""
def migrate_txt_to_json(filename, deck_name, target_directory = PUBLIC_DATA_FOLDER):
    # TODO by default, it looks for source_filename in public/data folder
    # TODO target_directory is optional, if not specified it targets to current directory
    # TODO add explanation of different parameters in the python doc comment and in readme

    if not filename:
        # TODO improve this log message
        logger.info("please provide filename")
        return

    # this first implementation looks source_filename at public/data and throws result to it
    look_up_folder = PUBLIC_DATA_FOLDER

    file_path = os.join(PUBLIC_DATA_FOLDER, filename)

    if not file_path:
        logger.info("file not found")
        return

    language = get_language(source_filename)

    flashcard_list = []

    with open(source_filename, 'r') as reader:
        for line in reader.readLines():
            if not empty_or_comment(line):
                flashcard = parse_flashcard_line(line)
                if flashcard is not None:
                    flashcard_list.append(flashcard)

    if len(flashcard_list) == 0:
        return

    # TODO write file

def parse_flashcard_line(line):
    chunks = line.split("|")
    if len(chunks) < 2:
        return None

    front = chunks[0].strip()
    back = chunks[1].strip()

    flashcard = {}
    flashcard.front = front
    flashcard.back = back

    if len(chunks) > 2:
        flashcard.example = chunks[2].strip()

    return flashcard

def get_language(filename):
    EN_GB if ".en" in filename else DE_DE

def empty_or_comment(line):
    return not line or line[0] == '#'