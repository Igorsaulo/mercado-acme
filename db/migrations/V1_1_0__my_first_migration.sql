CREATE TABLE users
(
    user_id       INT AUTO_INCREMENT PRIMARY KEY,
    user_name     VARCHAR(255),
    user_email    VARCHAR(255),
    user_password VARCHAR(255)
);

CREATE TABLE customers
(
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id     INT,
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE shopping_cart
(
    shopping_cart_id      INT AUTO_INCREMENT PRIMARY KEY,
    shopping_cart_user_id INT,
    total_price           DECIMAL(10, 2),
    total_items           INT,
    customer_id           INT,
    FOREIGN KEY (shopping_cart_user_id) REFERENCES users (user_id),
    FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
);

CREATE TABLE sellers
(
    seller_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id   INT,
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE sales
(
    sale_id          INT AUTO_INCREMENT PRIMARY KEY,
    sale_total_price DECIMAL(10, 2),
    sale_total_items INT,
    seller_id        INT,
    customer_id      INT,
    FOREIGN KEY (seller_id) REFERENCES sellers (seller_id),
    FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
);

CREATE TABLE products
(
    product_id          INT AUTO_INCREMENT PRIMARY KEY,
    product_name        VARCHAR(255),
    product_description TEXT,
    product_image       VARCHAR(255),
    product_category    VARCHAR(255),
    product_price       DECIMAL(10, 2),
    product_stock       INT,
    sale_id             INT,
    shopping_cart_id    INT,
    seller_id           INT,
    FOREIGN KEY (sale_id) REFERENCES sales (sale_id),
    FOREIGN KEY (shopping_cart_id) REFERENCES shopping_cart (shopping_cart_id),
    FOREIGN KEY (seller_id) REFERENCES sellers (seller_id)
);

CREATE TABLE orders
(
    order_id          INT AUTO_INCREMENT PRIMARY KEY,
    order_user_id     INT,
    order_total_price DECIMAL(10, 2),
    order_total_items INT,
    customer_id       INT,
    seller_id         INT,
    FOREIGN KEY (order_user_id) REFERENCES users (user_id),
    FOREIGN KEY (customer_id) REFERENCES customers (customer_id),
    FOREIGN KEY (seller_id) REFERENCES sellers (seller_id)
);

CREATE TABLE deliveries
(
    delivery_id            INT AUTO_INCREMENT PRIMARY KEY,
    delivery_date          DATE,
    previous_delivery_date DATE,
    next_delivery_date     DATE,
    sale_id                INT,
    FOREIGN KEY (sale_id) REFERENCES sales (sale_id)
);
