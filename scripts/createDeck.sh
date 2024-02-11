#!/bin/bash -e
set -euo pipefail

SCRIPTS_DIR="$(dirname "$0")"

curl -i -X POST \
          -H 'Content-Type: application/json' \
          -d @"$SCRIPTS_DIR/deck.json" \
          http://localhost:8080/api/decks/
# TODO add error handling if curl command fails
echo "Deck created"