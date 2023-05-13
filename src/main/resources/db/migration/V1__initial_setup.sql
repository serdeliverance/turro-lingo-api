DROP TABLE IF EXISTS "deck";

CREATE TABLE IF NOT EXISTS "deck"(
    id BIGSERIAL PRIMARY KEY,
    "name" VARCHAR(255) NOT NULL,
    "slug" VARCHAR(255) NOT NULL,
    "type" VARCHAR(50) NOT NULL,
    "description" VARCHAR(255),
    "language" VARCHAR(20) NOT NULL,
    "tags" VARCHAR(255)
);

DROP TABLE IF EXISTS "flashcard";

CREATE TABLE IF NOT EXISTS "flashcard" (
    id BIGSERIAL PRIMARY KEY,
    "front" VARCHAR(255) NOT NULL,
    "back" VARCHAR(255) NOT NULL,
    "example" VARCHAR(255),
    "deck_id" BIGINT NOT NULL,
    CONSTRAINT fk_deck_id FOREIGN KEY(deck_id) REFERENCES "deck"(id)
);
