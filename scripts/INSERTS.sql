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
-- Inserción de cuentas en la tabla account
INSERT INTO account (account_name, email_address, group_name) VALUES
                                                                               ('User1', 'user1@example.com', '1' ),
                                                                               ('User2', 'user2@example.com', '1');

-- Inserción de productos en la tabla product
INSERT INTO product (GTIN, SKU, label) VALUES
                                           (1234567890123, 'SKU123456', 'Laptop'),
                                           (1234567890124, 'SKU123457', 'Mouse'),
                                           (1234567890125, 'SKU123458', 'Keyboard'),
                                           (2234567890123, 'SKU223456', 'Smartphone'),
                                           (2234567890124, 'SKU223457', 'Headphones'),
                                           (2234567890125, 'SKU223458', 'Charger');

-- Relación de productos con cuentas (tabla account_product)
INSERT INTO account_product (account_id_fk, product_id_fk) VALUES
                                                               (1, 1), -- User1 -> Laptop
                                                               (1, 2), -- User1 -> Mouse
                                                               (1, 3), -- User1 -> Keyboard
                                                               (2, 4), -- User2 -> Smartphone
                                                               (2, 5), -- User2 -> Headphones
                                                               (2, 6); -- User2 -> Charger

-- Inserción de atributos en la tabla attribute
INSERT INTO attribute (account_id_fk, attribute_name, attribute_type) VALUES
                                                                          (1, 'Age', 'Integer'),
                                                                          (1, 'MembershipLevel', 'Text'),
                                                                          (2, 'Age', 'Integer'),
                                                                          (2, 'SubscriptionType', 'Text');

-- Relación de cuentas con atributos (tabla account_attribute)
INSERT INTO account_attribute (account_id_fk, attribute_id_fk) VALUES
                                                                   (1, 1), -- User1 -> Age
                                                                   (1, 2), -- User1 -> MembershipLevel
                                                                   (2, 3), -- User2 -> Age
                                                                   (2, 4); -- User2 -> SubscriptionType

-- Valores para atributos de productos (tabla product_attribute)
INSERT INTO product_attribute (attribute_id_fk, product_id_fk, account_id_fk, value) VALUES
                                                                                         (1, 1, 1, '18'), -- Age for Laptop by User1
                                                                                         (2, 2, 1, 'Gold'), -- MembershipLevel for Mouse by User1
                                                                                         (3, 4, 2, '25'), -- Age for Smartphone by User2
                                                                                         (4, 5, 2, 'Premium'); -- SubscriptionType for Headphones by User2

-- Inserción de categorías en la tabla category
INSERT INTO category (account_id_fk, category_name) VALUES
                                                        (1, 'Electronics'),
                                                        (1, 'Accessories'),
                                                        (2, 'Gadgets'),
                                                        (2, 'AudioDevices');

-- Relación de cuentas con categorías (tabla account_category)
INSERT INTO account_category (account_id_fk, category_id_fk) VALUES
                                                                 (1, 1), -- User1 -> Electronics
                                                                 (1, 2), -- User1 -> Accessories
                                                                 (2, 3), -- User2 -> Gadgets
                                                                 (2, 4); -- User2 -> AudioDevices

-- Relación de productos con categorías (tabla product_category)
INSERT INTO product_category (category_id_fk, product_id_fk, account_id_fk) VALUES
                                                                                (1, 1, 1), -- Laptop -> Electronics
                                                                                (2, 2, 1), -- Mouse -> Accessories
                                                                                (3, 4, 2), -- Smartphone -> Gadgets
                                                                                (4, 5, 2); -- Headphones -> AudioDevices

-- Verificación de los datos insertados
SELECT * FROM account;
SELECT * FROM product;
SELECT * FROM account_product;
SELECT * FROM attribute;
SELECT * FROM account_attribute;
SELECT * FROM product_attribute;
SELECT * FROM category;
SELECT * FROM account_category;
SELECT * FROM product_category;
