#!/bin/bash -e

set -euo pipefail

source scripts/common.sh

ME=`basename $0`
WORKSPACE=$(pwd)

echo ----------------------------------------------
java -version
echo "javaLocation: $(whereis java)"
echo "nodeVer: $(node -v)"
echo ----------------------------------------------

echo "[${ME}] Starting up dockers, building backend..."

setup_dockers

starting_backend