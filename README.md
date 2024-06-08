# m-flashcards

Flashcards for learning languages. This project born from a real need and also comes in handy to dive deeper into `Java`, `Spring Boot`, `Nextjs`, `Typescript` and related technologies.

## Stack

- `Nextjs + Typescript`
- `Java + Spring Boot`
- `Cypress`
- `Postgres`
- `Docker`

## Requirements

- `Node v18.x` (you can use [NVM](https://github.com/nvm-sh/nvm) for setting the right version easily)
- `Java 21`
- `Docker`

If you have [NVM](https://github.com/nvm-sh/nvm) and [SdkMan](https://sdkman.io/) installed, you can set the required `Node` and `JDK` versions by running the following commands

```
nvm use     # inside ui folder
sdk env     # inside root folder
```

## Data model

So far the model is very simple:

```kotlin
data class Deck(val name: String, val type: String, val tags: List<String>, val flashcards: List<Flashcard>)

data class Flashcard(val front: String, val back: String, val example: String?)
```

We have `decks` and `flashcards`. A `deck` is a `flashcard` set with some metadata, such as `name` and `type`.
`type` indicates with type of `flashcard` the `deck` stores. `type` could be `phrase` or `vocabulary`. `vocabulary` flashcards use to have `example` value set.
`flaschcard` domain class is self-explanatory.

## Run local

To run both backend and frontend, simply run the following command.

```
bash scripts/runLocal.sh
```

It will run:

- backend on <http://localhost:8080>
- frontend on <http://localhost:3000>
- postgres db on <http://localhost:45432>

## Run (just) backend locally

```bash
./gradlew bootRun
```

## Run (just) frontend locally

```bash
cd ui
yarn dev
```

It runs the frontend on localhost:3000

## Start DB

run `docker-compose`:

```bash
docker-compose up
```

## More info

- [Useful scripts](./docs/scripts.md)
