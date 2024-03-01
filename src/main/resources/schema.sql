CREATE SCHEMA IF NOT EXISTS test;

CREATE TABLE IF NOT EXISTS test.product
(
    id
    INT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    name
    VARCHAR
(
    255
),
    price DECIMAL
(
    10,
    2
)
    );
