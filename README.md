# Turro Lingo API

Flashcards for learning languages. This project born from a real need and also comes in handy to dive deeper into `Java`, `Spring Boot`, `Nextjs`, `Typescript` and related technologies.

## Stack

- `Java + Spring Boot`
- `Postgres`
- `Docker`

## Requirements

- `Java 21`
- `Docker`

If you have [SdkMan](https://sdkman.io/) installed, you can set the required `Node` and `JDK` versions by running the following command

```
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

```
bash scripts/runLocal.sh
```

It will run:

- backend on <http://localhost:8080>
- postgres db on <http://localhost:45432>

## Run (just) backend locally

```bash
./gradlew bootRun
```

## Start DB

run `docker-compose`:

```bash
docker-compose up
```

## More info

- [Useful scripts](./docs/scripts.md)
