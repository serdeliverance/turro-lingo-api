# m-flashcards

Flashcards for learning languages. This project born from a real need and also comes in handy to dive deeper into `Nextjs`, `Kotlin`, `Spring Webflux` and related technologies.

## Stack

- `Nextjs + Typescript`
- `Kotlin + Spring Webflux`
- `Cypress`
- `Mongo`
- `Docker`

## Requirements

- `Node v18.x` (you can use [NVM](https://github.com/nvm-sh/nvm) for setting the right version easily)
- `Java 17`
- `Docker`

## Run backend locally

```
./gradlew bootRun
```

## Run frontend locally

```
cd ui
yarn dev
```

It runs the frontend on localhost:3000

## Start DB

run `docker-compose`:

```
docker-compose up
```
