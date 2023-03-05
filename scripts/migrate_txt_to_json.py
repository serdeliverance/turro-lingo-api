"""Migrates txt vocabulary files to json

Migrates txt vocabulary field to json, so It is easier to insert into db using mongo. It parses lines that have the following format:

<<word>> | <<word in english>> [| <<example>> ]

So, we can see that example section is optional (that why it is on [] ).

Also, lines that starts with # are ignored. That is to allow you to make comments in the file.
"""