#!/bin/bash

# Logging
function me {
  basename $0
}

function timestamp {
  date +"%F %T"
}

function log_info {
    echo -e "\033[0;32m[$(me) - $(timestamp)][INFO] $*\033[0m"
}

# Infrastructure
function setup_dockers() {
    log_info "Starting up dockers..."
    docker-compose up -d
    sleep 5
}

function starting_frontend() {
    log_info "Starting frontend..."
    if [ -d ~/.nvm ]
    then
      source ~/.nvm/nvm.sh
      cd $WORKSPACE/ui
      nvm use
      cd ..
    fi
    cd ui
    nvm use
    yarn install
    yarn dev
}

function starting_backend() {
    log_info "Starting backend..."
    cd $WORKSPACE
    ./gradlew bootRun
}