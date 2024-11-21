USE grupo05DB;
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE grupo05DB.account;
TRUNCATE TABLE grupo05DB.account_attribute;
TRUNCATE TABLE grupo05DB.account_category;
TRUNCATE TABLE grupo05DB.account_product;
TRUNCATE TABLE grupo05DB.attribute;
TRUNCATE TABLE grupo05DB.category;
TRUNCATE TABLE grupo05DB.product;
TRUNCATE TABLE grupo05DB.product_attribute;
TRUNCATE TABLE grupo05DB.product_category;
SET FOREIGN_KEY_CHECKS = 1;
-- Insertar cuentas
INSERT INTO account (account_name, email_address)
VALUES 
    ('User1', 'user1@example.com'),
    ('User2', 'user2@example.com'),
    ('User3', 'user3@example.com');

-- Insertar atributos
INSERT INTO attribute (account_id_fk, attribute_name, attribute_type)
VALUES
    (1, 'Color', 'String'),
    (1, 'Size', 'String'),
    (2, 'Weight', 'Integer'),
    (3, 'Material', 'String');

-- Insertar relación entre cuentas y atributos
INSERT INTO account_attribute (account_id_fk, attribute_id_fk)
VALUES
    (1, 1), -- User1 tiene atributo 'Color'
    (1, 2), -- User1 tiene atributo 'Size'
    (2, 3), -- User2 tiene atributo 'Weight'
    (3, 4); -- User3 tiene atributo 'Material'

-- Insertar categorías
INSERT INTO category (account_id_fk, category_name)
VALUES
    (1, 'Electronics'),
    (1, 'Home Appliances'),
    (2, 'Furniture'),
    (3, 'Clothing');

-- Insertar relación entre cuentas y categorías
INSERT INTO account_category (account_id_fk, category_id_fk)
VALUES
    (1, 1), -- User1 tiene categoría 'Electronics'
    (1, 2), -- User1 tiene categoría 'Home Appliances'
    (2, 3), -- User2 tiene categoría 'Furniture'
    (3, 4); -- User3 tiene categoría 'Clothing'

-- Insertar productos
INSERT INTO product (GTIN, SKU, label)
VALUES
    (1111111111111, 'SKU1111', 'Smartphone'),
    (2222222222222, 'SKU2222', 'Washing Machine'),
    (3333333333333, 'SKU3333', 'Sofa'),
    (4444444444444, 'SKU4444', 'T-Shirt');

-- Insertar relación entre cuentas y productos
INSERT INTO account_product (account_id_fk, product_id_fk)
VALUES
    (1, 1), -- User1 tiene 'Smartphone'
    (1, 2), -- User1 tiene 'Washing Machine'
    (2, 3), -- User2 tiene 'Sofa'
    (3, 4); -- User3 tiene 'T-Shirt'

-- Insertar relación entre productos y atributos (limitado por cuentas)
INSERT INTO product_attribute (attribute_id_fk, product_id_fk, account_id_fk, value)
VALUES
    (1, 1, 1, 'blue'), -- Atributo 'Color' de User1 aplicado a 'Smartphone'
    (2, 1, 1, '10'), -- Atributo 'Size' de User1 aplicado a 'Smartphone'
    (2, 2, 1, 'grande'), -- Atributo 'Size' de User1 aplicado a 'Washing Machine'
    (3, 3, 2, '55'), -- Atributo 'Weight' de User2 aplicado a 'Sofa'
    (4, 4, 3, 'algodon'); -- Atributo 'Material' de User3 aplicado a 'T-Shirt'

-- Insertar relación entre productos y categorías (limitado por cuentas)
INSERT INTO product_category (category_id_fk, product_id_fk, account_id_fk)
VALUES
    (1, 1, 1), -- 'Smartphone' de User1 pertenece a 'Electronics'
    (2, 2, 1), -- 'Washing Machine' de User1 pertenece a 'Home Appliances'
    (3, 3, 2), -- 'Sofa' de User2 pertenece a 'Furniture'
    (4, 4, 3); -- 'T-Shirt' de User3 pertenece a 'Clothing'

-- Consultar datos insertados para verificar
SELECT * FROM account;
SELECT * FROM attribute;
SELECT * FROM account_attribute;
SELECT * FROM category;
SELECT * FROM account_category;
SELECT * FROM product;
SELECT * FROM account_product;
SELECT * FROM product_attribute;
SELECT * FROM product_category;
