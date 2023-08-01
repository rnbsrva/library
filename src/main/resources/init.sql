CREATE TABLE IF NOT EXISTS author
(
    author_id SERIAL PRIMARY KEY,
    name      VARCHAR,
    surname   VARCHAR
);

CREATE TABLE IF NOT EXISTS book
(
    book_id     SERIAL PRIMARY KEY,
    name        VARCHAR,
    description VARCHAR,
    author_id   INT,
    FOREIGN KEY (author_id) REFERENCES author (author_id)
);