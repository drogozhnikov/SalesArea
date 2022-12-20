create schema if not exists sales;

SET search_path TO sales;

DROP TABLE IF EXISTS company;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS position;

CREATE TABLE IF NOT EXISTS company
(
    id          SERIAL PRIMARY KEY,
    name        CHAR(100) not null unique,
    email       CHAR(100) not null,
    created     timestamp not null,
    description text      not null
);

DROP TYPE IF EXISTS user_role;
CREATE TYPE user_role AS ENUM ('MANAGER', 'DIRECTOR', 'STORAGE_MANAGER');

CREATE TABLE IF NOT EXISTS users
(
    id         SERIAL PRIMARY KEY,
    username   CHAR(100) not null unique,
    email      CHAR(100) not null unique,
    name       CHAR(100) not null,
    role       user_role not null,
    created    timestamp not null,
    updated    timestamp not null,
    company_id int       not null
);

CREATE TABLE IF NOT EXISTS item
(
    id          SERIAL PRIMARY KEY,
    name        CHAR(100) not null,
    description CHAR(100) not null,
    created     timestamp not null,
    category_id int       not null
);

CREATE TABLE IF NOT EXISTS category
(
    id              SERIAL PRIMARY KEY,
    name            CHAR(100) not null,
    parent_category INT,
    description     CHAR(100)
);

CREATE TABLE IF NOT EXISTS position
(
    id         SERIAL PRIMARY KEY,
    item_id    int       not null,
    company_id int       not null,
    created_by int       not null,
    created    timestamp not null,
    amount     numeric   not null CHECK (amount > 0),
    min_amount numeric   not null CHECK (amount > 0)
);


ALTER TABLE users
    ADD FOREIGN KEY (company_id) REFERENCES company (id);
ALTER TABLE item
    ADD FOREIGN KEY (category_id) REFERENCES category (id);
ALTER TABLE category
    ADD FOREIGN KEY (parent_category) REFERENCES category (id);

ALTER TABLE position
    ADD FOREIGN KEY (item_id) REFERENCES item (id);
ALTER TABLE position
    ADD FOREIGN KEY (company_id) REFERENCES company (id);
ALTER TABLE position
    ADD FOREIGN KEY (created_by) REFERENCES users (id);


