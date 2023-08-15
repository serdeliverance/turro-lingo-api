DROP TABLE IF EXISTS "noun";

CREATE TABLE IF NOT EXISTS "noun"(
    id BIGSERIAL PRIMARY KEY,
    "name" VARCHAR(50) NOT NULL,
    "description" VARCHAR(255) NOT NULL,
    "article" VARCHAR(10) NOT NULL,
    "fullname" VARCHAR(255) NOT NULL,
    "tags" VARCHAR(255)
);