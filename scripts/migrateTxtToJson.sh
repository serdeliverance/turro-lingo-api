#!/bin/bash
# IMPORTANT: run this script from project ROOT folder

# TODO add param validation / check amount of params
SOURCE_DIR=$PWD/ui/public/data/$1
TARGET_DIR=$PWD/ui/public/data

python3 scripts/migrate_txt_to_json.py $SOURCE_DIR $TARGET_DIR $2