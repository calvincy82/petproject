DROP SEQUENCE IF EXISTS person_seq;
DROP SEQUENCE IF EXISTS product_seq;
DROP SEQUENCE IF EXISTS product_person_seq;

DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS product_person;

CREATE SEQUENCE person_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE product_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE product_person_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE person
(
	id BIGINT NOT NULL PRIMARY KEY,
	username VARCHAR(255),
	password VARCHAR(255)
);

CREATE TABLE product
(
	id BIGINT NOT NULL PRIMARY KEY,
	product_code VARCHAR(255),
	product_description VARCHAR(255)
);

CREATE TABLE product_person
(
	id BIGINT NOT NULL PRIMARY KEY,
	product_id VARCHAR(255),
	person_id VARCHAR(255)
);

INSERT into product VALUES (nextval('product_seq'), 'product1', 'Product 1');
INSERT into product VALUES (nextval('product_seq'), 'product2', 'Product 2');
INSERT into product VALUES (nextval('product_seq'), 'product3', 'Product 3');