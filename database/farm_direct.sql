CREATE DATABASE IF NOT EXISTS farm_direct CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE farm_direct;
CREATE TABLE users(
 id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100) NOT NULL, email VARCHAR(150) NOT NULL UNIQUE,
 phone VARCHAR(20), address TEXT, password VARCHAR(100) NOT NULL,
 role ENUM('FARMER','CUSTOMER','ADMIN') NOT NULL DEFAULT 'CUSTOMER',
 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE products(
 id INT AUTO_INCREMENT PRIMARY KEY, farmer_id INT NOT NULL, name VARCHAR(120) NOT NULL,
 category VARCHAR(60) NOT NULL, price DECIMAL(10,2) NOT NULL, stock INT NOT NULL DEFAULT 0,
 description TEXT, available BOOLEAN NOT NULL DEFAULT TRUE, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 CONSTRAINT fk_product_farmer FOREIGN KEY(farmer_id) REFERENCES users(id) ON DELETE CASCADE
);
CREATE TABLE orders(
 id INT AUTO_INCREMENT PRIMARY KEY, customer_id INT NOT NULL, total_amount DECIMAL(12,2) NOT NULL,
 status ENUM('PLACED','ACCEPTED','PACKED','COMPLETED','CANCELLED') DEFAULT 'PLACED',
 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 CONSTRAINT fk_order_customer FOREIGN KEY(customer_id) REFERENCES users(id)
);
CREATE TABLE order_items(
 id INT AUTO_INCREMENT PRIMARY KEY, order_id INT NOT NULL, product_id INT NOT NULL,
 quantity INT NOT NULL, unit_price DECIMAL(10,2) NOT NULL,
 CONSTRAINT fk_item_order FOREIGN KEY(order_id) REFERENCES orders(id) ON DELETE CASCADE,
 CONSTRAINT fk_item_product FOREIGN KEY(product_id) REFERENCES products(id)
);
-- Register your own account through the website, then promote it to admin:
-- UPDATE users SET role='ADMIN' WHERE email='your-email@example.com';
