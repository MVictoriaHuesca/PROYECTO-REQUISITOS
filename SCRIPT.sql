DROP DATABASE IF EXISTS grupo05DB;
CREATE DATABASE grupo05DB;
USE grupo05DB;

CREATE TABLE accounts (
	account_id INT NOT NULL AUTO_INCREMENT,
    account_name VARCHAR(50) NOT NULL UNIQUE,
    email_address VARCHAR(50) NOT NULL UNIQUE,
    -- account_profile_picture VARCHAR(50),
    created_at TIMESTAMP NOT NULL DEFAULT (NOW()),
    PRIMARY KEY (account_id)
    -- añadir más atributos
);

INSERT INTO accounts(account_name, email_address) 
VALUES
('cuenta_owner', 'cuenta_owner@gmail.com'),
('cuenta_user', 'cuenta_user@gmail.com'),
('cuenta_agente', 'cuenta_agente@gmail.com');

SELECT * FROM accounts;

CREATE TABLE products(
	product_id INT NOT NULL AUTO_INCREMENT,
	GTIN BIGINT NOT NULL CHECK (GTIN BETWEEN 0 AND 9999999999999),	-- esto a lo mejor se puede mejorar
    SKU VARCHAR(12) NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL DEFAULT (NOW()),
    -- modified_at TIMESTAMP NOT NULL DEFAULT (NOW()),
    label VARCHAR(50) NOT NULL UNIQUE,
    PRIMARY KEY (product_id)
);

INSERT INTO products (GTIN, SKU)
VALUES
(111111111111,'1111-1111111'),
(222222222222,'2222-2221111'),
(333333333333,'3333-3331111');

SELECT * FROM products;

CREATE TABLE account_products (
	account_id_fk INT NOT NULL,
    product_id_fk INT NOT NULL,
    FOREIGN KEY(account_id_fk) REFERENCES accounts(account_id),
    FOREIGN KEY(product_id_fk) REFERENCES products(product_id),
    PRIMARY KEY(account_id_fk, product_id_fk)
);

INSERT INTO account_products(account_id_fk, product_id_fk)
VALUES 
(1,1),
(1,2),
(1,3),
(2,1),
(2,2),
(2,3),
(3,1),
(3,2),
(3,3);

SELECT * FROM account_products;

CREATE TABLE category (
	category_id INT NOT NULL,
    category_name VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT (NOW()),
    PRIMARY KEY(category_id)
);

CREATE TABLE account_category (
	category_id_fk INT NOT NULL,
    account_id_fk INT NOT NULL,
    FOREIGN KEY(category_id_fk) REFERENCES category(category_id),
    FOREIGN KEY(account_id_fk) REFERENCES accounts(account_id),
    PRIMARY KEY(category_id_fk,account_id_fk)
);

CREATE TABLE product_category (
	category_id_fk INT NOT NULL,
    product_id_fk INT NOT NULL,
    FOREIGN KEY(category_id_fk) REFERENCES category(category_id),
    FOREIGN KEY(product_id_fk) REFERENCES products(product_id),
    PRIMARY KEY(category_id_fk,product_id_fk)
);

CREATE TABLE attributes (
	attribute_id INT NOT NULL,
    attribute_name VARCHAR(50) NOT NULL,
    attribute_type VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT (NOW()),
    PRIMARY KEY(attribute_id)
);

CREATE TABLE account_attributes (
	attribute_id_fk INT NOT NULL,
    account_id_fk INT NOT NULL,
    FOREIGN KEY(attribute_id_fk) REFERENCES attributes(attribute_id),
    FOREIGN KEY(account_id_fk) REFERENCES accounts(account_id),
    PRIMARY KEY(attribute_id_fk,account_id_fk)
);

CREATE TABLE product_attributes (
	attribute_id_fk INT NOT NULL,
    product_id_fk INT NOT NULL,
    FOREIGN KEY(attribute_id_fk) REFERENCES attributes(attribute_id),
    FOREIGN KEY(product_id_fk) REFERENCES products(product_id),
    PRIMARY KEY(attribute_id_fk,product_id_fk)
);
