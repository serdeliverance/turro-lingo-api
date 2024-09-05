DROP TABLE IF EXISTS "bucket";

CREATE TABLE IF NOT EXISTS "bucket"(
    id BIGSERIAL PRIMARY KEY,
    "user_id" VARCHAR(50) NOT NULL,
    "description" VARCHAR(255),
    "bucket_item" JSONB NOT NULL,
    "created_at" TIMESTAMPTZ NOT NULL
);