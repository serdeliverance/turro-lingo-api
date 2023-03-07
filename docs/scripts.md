# Scripts

## txt to json migration script

This script allows you to migrate `.txt` files to `.json`, so it is easier to get vocabulary/phrases and migrate them later to the DB.
The `.txt` must follow this format:

```
<<word>> | <<word in english>> [| <<example>> ]
```

So, we can see that example section is optional (that why it is on `[]`).

The script receives the following params:

```
./scripts/migrateTxtToJson.sh <<filename>> <<deck_name>>
```

Example:

```
./scripts/migrateTxtToJson.sh example.txt german-101
```

It will generate a file `example.json` inside `ui/public/data` folder.

You have to be on project root folder in order to run this script.