DROP DATABASE IF EXISTS grupo05DB;
CREATE DATABASE grupo05DB;
USE grupo05DB;

CREATE TABLE account (
	account_id INT NOT NULL AUTO_INCREMENT,
    account_name VARCHAR(50) NOT NULL UNIQUE,
    email_address VARCHAR(50) NOT NULL UNIQUE,
    account_profile_picture VARCHAR(64),
    created_at TIMESTAMP NOT NULL DEFAULT (NOW()),
    group_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (account_id)
);

CREATE TABLE product (
    product_id INT NOT NULL AUTO_INCREMENT,
    GTIN BIGINT NOT NULL CHECK (GTIN BETWEEN 0 AND 9999999999999),
    SKU VARCHAR(12) NOT NULL UNIQUE,
    label VARCHAR(50) NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL DEFAULT (NOW()),
    PRIMARY KEY(product_id)
);

CREATE TABLE account_product (
    account_id_fk INT NOT NULL,
    product_id_fk INT NOT NULL,
    FOREIGN KEY(account_id_fk) REFERENCES account(account_id),
    FOREIGN KEY(product_id_fk) REFERENCES product(product_id),
    PRIMARY KEY(account_id_fk, product_id_fk)
);

CREATE TABLE attribute (
	attribute_id INT NOT NULL AUTO_INCREMENT,
    account_id_fk INT NOT NULL,
    attribute_name VARCHAR(50) NOT NULL,
    attribute_type ENUM('Integer', 'Double', 'Text') NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT (NOW()),
    FOREIGN KEY(account_id_fk) REFERENCES account(account_id),
    PRIMARY KEY(attribute_id)
);

CREATE TABLE account_attribute(
    account_id_fk INT NOT NULL,
    attribute_id_fk INT NOT NULL,
    FOREIGN KEY(account_id_fk) REFERENCES account(account_id),
    FOREIGN KEY(attribute_id_fk) REFERENCES attribute(attribute_id),
    PRIMARY KEY(account_id_fk, attribute_id_fk)
);

CREATE TABLE product_attribute (
	attribute_id_fk INT NOT NULL,
    product_id_fk INT NOT NULL,
    account_id_fk INT NOT NULL,
    value VARCHAR(50),
    FOREIGN KEY(attribute_id_fk) REFERENCES attribute(attribute_id),
    FOREIGN KEY(product_id_fk) REFERENCES product(product_id),
    FOREIGN KEY(account_id_fk) REFERENCES account(account_id),
    PRIMARY KEY(attribute_id_fk, product_id_fk, account_id_fk)
);

CREATE TABLE category (
	category_id INT NOT NULL AUTO_INCREMENT,
    account_id_fk INT NOT NULL,
    category_name VARCHAR(50) NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL DEFAULT (NOW()),
    FOREIGN KEY(account_id_fk) REFERENCES account(account_id),
    PRIMARY KEY(category_id)
);

CREATE TABLE account_category (
    account_id_fk INT NOT NULL,
    category_id_fk INT NOT NULL,
    FOREIGN KEY(account_id_fk) REFERENCES account(account_id),
    FOREIGN KEY(category_id_fk) REFERENCES category(category_id),
    PRIMARY KEY(account_id_fk, category_id_fk)
);


CREATE TABLE product_category (
	category_id_fk INT NOT NULL,
    product_id_fk INT NOT NULL,
    account_id_fk INT NOT NULL,
    FOREIGN KEY(category_id_fk) REFERENCES category(category_id),
    FOREIGN KEY(product_id_fk) REFERENCES product(product_id),
    FOREIGN KEY(account_id_fk) REFERENCES account(account_id),
    PRIMARY KEY(category_id_fk, product_id_fk, account_id_fk)
);

CREATE TABLE relationship (
	relationship_id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL DEFAULT (NOW()),
    PRIMARY KEY(relationship_id)
);

CREATE TABLE relationship_product (
    relationship_id_fk INT NOT NULL,
    product1_id_fk INT NOT NULL,
    product2_id_fk INT NOT NULL,
    FOREIGN KEY(relationship_id_fk) REFERENCES relationship(relationship_id),
    FOREIGN KEY(product1_id_fk) REFERENCES product(product_id),
    FOREIGN KEY(product2_id_fk) REFERENCES product(product_id),
    PRIMARY KEY(relationship_id_fk, product1_id_fk, product2_id_fk)
);

CREATE TABLE account_relationship (
    account_id_fk INT NOT NULL,
    relationship_id_fk INT NOT NULL,
    FOREIGN KEY(account_id_fk) REFERENCES account(account_id),
    FOREIGN KEY(relationship_id_fk) REFERENCES relationship(relationship_id),
    PRIMARY KEY(account_id_fk, relationship_id_fk)
);
  