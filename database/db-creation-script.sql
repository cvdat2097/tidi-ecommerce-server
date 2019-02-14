-- Create databse
DROP DATABASE IF EXISTS `TIDI-ecommerce`;
CREATE DATABASE `TIDI-ecommerce` DEFAULT CHARACTER SET utf8 ;

USE `TIDI-ecommerce`;

-- Create tables
CREATE TABLE brand (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    brand_name NVARCHAR(100),
    
    PRIMARY KEY (id)
);

CREATE TABLE industry (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    industry_name NVARCHAR(100),
    
    PRIMARY KEY (id)
);

CREATE TABLE branch (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    branch_name NVARCHAR(100),
    industry_id INT UNSIGNED,
    
    PRIMARY KEY (id),
    
    CONSTRAINT FK_branch_industry
    FOREIGN KEY (industry_id) REFERENCES industry(id)
);

CREATE TABLE category (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    category_name NVARCHAR(100),
    branch_id INT UNSIGNED,
    
    PRIMARY KEY (id),
    
    CONSTRAINT FK_category_branch
    FOREIGN KEY (branch_id) REFERENCES branch(id)
);


CREATE TABLE product (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    product_name NVARCHAR(100) NOT NULL,
    price INT UNSIGNED NOT NULL,
    quantity INT UNSIGNED NOT NULL,
    brand_id INT UNSIGNED,
    industry_id INT UNSIGNED,
    branch_id INT UNSIGNED,
    category_id INT UNSIGNED,
    description LONGTEXT,
    images TEXT,
    active BOOLEAN DEFAULT TRUE,
    
    PRIMARY KEY (id),
    
    CONSTRAINT FK_product_brand
    FOREIGN KEY (brand_id) REFERENCES brand(id),
    CONSTRAINT FK_product_industry
    FOREIGN KEY (industry_id) REFERENCES industry(id),
    CONSTRAINT FK_product_branch
    FOREIGN KEY (branch_id) REFERENCES branch(id),
    CONSTRAINT FK_product_category
    FOREIGN KEY (category_id) REFERENCES category(id)
);


CREATE TABLE customer (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(30) NOT NULL,
    permission ENUM ('ADMIN', 'CUSTOMER', 'PUBLIC'),
    full_name NVARCHAR(100),
    date_of_birth DATE,
    gender ENUM ('MALE', 'FEMALE'),
    phone VARCHAR(15),
    email VARCHAR(50),
    address VARCHAR(300),
    avatar TEXT,
    is_verified BOOLEAN DEFAULT FALSE,
    active BOOLEAN DEFAULT TRUE,

    PRIMARY KEY (id)
);

CREATE TABLE cart (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    customer_id INT UNSIGNED NOT NULL,
    product_id INT UNSIGNED NOT NULL,
    quantity INT UNSIGNED NOT NULL,

    PRIMARY KEY (id),
    
	CONSTRAINT FK_cart_customer
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    CONSTRAINT FK_cart_product
    FOREIGN KEY (product_id) REFERENCES product(id)    
);

CREATE TABLE payment_method (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    payment_name NVARCHAR (100) NOT NULL,
    description TEXT,
    payment_fee INT UNSIGNED NOT NULL DEFAULT 0,
    
    PRIMARY KEY (id)
);

CREATE TABLE shipping_method (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    shipping_name NVARCHAR (100) NOT NULL,
    description TEXT,
    shipping_fee INT UNSIGNED NOT NULL DEFAULT 0,
    
    PRIMARY KEY (id)
);

CREATE TABLE orders (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    customer_id INT UNSIGNED NOT NULL,
    full_name NVARCHAR(100) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    email VARCHAR(50),
    address VARCHAR(300),
    total LONG,
    order_status ENUM('PENDING', 'CHECKED', 'PACKING', 'SHIPPING', 'CANCELED', 'SUCCESSFUL', 'PAID'),
    note VARCHAR(100),
    payment_method_id INT UNSIGNED NOT NULL,
    shipping_method_id INT UNSIGNED NOT NULL,
    zalopay_token TEXT,
    zalopay_transid MEDIUMTEXT,
    app_transid VARCHAR(20),
    
    PRIMARY KEY (id),
    
	CONSTRAINT FK_order_paymentmethod
    FOREIGN KEY (payment_method_id) REFERENCES payment_method(id),
    CONSTRAINT FK_order_shippingmethod
    FOREIGN KEY (shipping_method_id) REFERENCES shipping_method(id)
);

CREATE TABLE order_history (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    order_id INT UNSIGNED NOT NULL,
    order_status ENUM('PENDING', 'CHECKED', 'PACKING', 'SHIPPING', 'CANCELED', 'SUCCESSFUL', 'PAID'),
    order_date DATETIME,
    
    PRIMARY KEY (id),
    
    CONSTRAINT FK_orderhistory_order
    FOREIGN KEY (order_id) REFERENCES orders(id)
);

CREATE TABLE order_detail (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    order_id INT UNSIGNED NOT NULL,
    product_id INT UNSIGNED NOT NULL,
    quantity INT UNSIGNED NOT NULL DEFAULT 1,
    original_price INT UNSIGNED NOT NULL,
    final_price INT UNSIGNED NOT NULL,
    
    PRIMARY KEY (id),
    
    CONSTRAINT FK_orderdetail_order
    FOREIGN KEY (order_id) REFERENCES orders(id),
    CONSTRAINT FK_orderdetail_product
    FOREIGN KEY (product_id) REFERENCES product(id)
);



-- MOCK DATA
INSERT INTO customer
	(username, password, permission, full_name, phone, email)
VALUES
	('admin', '123', 'ADMIN', 'Nguyen Tran Tu', '015546488', 'admin@vng.com.vn'),
    ('user1', '123', 'CUSTOMER', 'Nguyen Tran A', '015546488', 'user1@vng.com.vn'),
    ('user2', '123', 'CUSTOMER', 'Nguyen Tran B', '015546456', 'user2@vng.com.vn'),
    ('user3', '123', 'CUSTOMER', 'Nguyen Tran C', '015546495', 'user3@vng.com.vn'),
    ('user4', '123', 'CUSTOMER', 'Nguyen Tran D', '015546148', 'user4@vng.com.vn');

INSERT INTO brand
	(brand_name)
VALUES   
	('Apple'),
    ('Samsung'),
    ('Nokia');

INSERT INTO industry
	(industry_name)
VALUES
	('Smartphone'),
    ('Vehicles'),
    ('Health');
    
INSERT INTO branch
	(branch_name, industry_id)
VALUES
	('Branch 1', 1),
	('Branch 2', 2),
    ('Branch 3', 2);

INSERT INTO category
	(category_name, branch_id)
VALUES
	('Category 1', 1),
	('Category 2', 2),
    ('Category 3', 2);


INSERT INTO product 
	(id, product_name, price, quantity, brand_id, industry_id, branch_id, category_id, description, images)
VALUES 
	(1, 'Điện Thoại iPhone X 64GB VN/A - Hàng Chính Hãng', '23490000', '100', '2', '1', '1', '1', '1\n2\n3', '["https://salt.tikicdn.com/cache/w1200/ts/product/1a/f0/a2/0978d091d83849160e6d31945ce9ae08.jpg","http://bpoc.com/wp-content/uploads/2016/08/Tidi-Products-Logo.jpg"]'),
    (2, 'Điện Thoại iPhone X 64GB VN/A - Hàng Chính Hãng', '23490000', '100', '2', '1', '1', '1', '1\n2\n3', '["https://salt.tikicdn.com/cache/w1200/ts/product/1a/f0/a2/0978d091d83849160e6d31945ce9ae08.jpg","http://bpoc.com/wp-content/uploads/2016/08/Tidi-Products-Logo.jpg"]'),
    (3, 'Điện Thoại iPhone X 64GB VN/A - Hàng Chính Hãng', '23490000', '100', '2', '1', '1', '1', '1\n2\n3', '["https://salt.tikicdn.com/cache/w1200/ts/product/1a/f0/a2/0978d091d83849160e6d31945ce9ae08.jpg","http://bpoc.com/wp-content/uploads/2016/08/Tidi-Products-Logo.jpg"]'),
    (4, 'Điện Thoại iPhone X 64GB VN/A - Hàng Chính Hãng', '23490000', '100', '2', '1', '1', '1', '1\n2\n3', '["https://salt.tikicdn.com/cache/w1200/ts/product/1a/f0/a2/0978d091d83849160e6d31945ce9ae08.jpg","http://bpoc.com/wp-content/uploads/2016/08/Tidi-Products-Logo.jpg"]'),
    (5, 'Điện Thoại iPhone X 64GB VN/A - Hàng Chính Hãng', '23490000', '100', '2', '1', '1', '1', '1\n2\n3', '["https://salt.tikicdn.com/cache/w1200/ts/product/1a/f0/a2/0978d091d83849160e6d31945ce9ae08.jpg","http://bpoc.com/wp-content/uploads/2016/08/Tidi-Products-Logo.jpg"]'),
    (6, 'Điện Thoại iPhone X 64GB VN/A - Hàng Chính Hãng', '23490000', '100', '2', '1', '1', '1', '1\n2\n3', '["https://salt.tikicdn.com/cache/w1200/ts/product/1a/f0/a2/0978d091d83849160e6d31945ce9ae08.jpg","http://bpoc.com/wp-content/uploads/2016/08/Tidi-Products-Logo.jpg"]');
