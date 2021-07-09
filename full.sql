BEGIN;


DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products
(
    id    bigserial PRIMARY KEY,
    title VARCHAR(255),
    price int
);
INSERT INTO products (title, price)
VALUES ('milk', 79),
       ('bread', 24),
       ('butter', 220),
       ('cheese', 350),
       ('coca-cola', 69);

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users
(
    id   bigserial PRIMARY KEY,
    name VARCHAR(255)
);
INSERT INTO users (name)
VALUES ('Alexander'),
       ('Bob');

DROP TABLE IF EXISTS products_users CASCADE;
CREATE TABLE products_users
(
    product_id bigint,
    user_id    bigint,
    FOREIGN KEY (product_id) REFERENCES products (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);
INSERT INTO products_users (product_id, user_id)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (5, 1),
       (4, 1),
       (1, 1),
       (5, 1),
       (2, 2),
       (3, 2);


COMMIT;