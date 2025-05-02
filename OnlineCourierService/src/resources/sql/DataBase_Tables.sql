--Mysql database
CREATE TABLE admin (
    admin_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL DEFAULT 'Manager',
    email VARCHAR(50) UNIQUE
);

CREATE TABLE customer (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    phone VARCHAR(15) UNIQUE,
    email VARCHAR(100) UNIQUE
);

CREATE TABLE courier (
    courier_id INT PRIMARY KEY AUTO_INCREMENT,
    pickup_location VARCHAR(255) NOT NULL,
    destination VARCHAR(255) NOT NULL,
    weight DECIMAL(10,2) NOT NULL,
    type VARCHAR(50),
    cost DECIMAL(10,2) NOT NULL,
    customer_id INT NOT NULL,
    booking_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    expected_delivery DATETIME,
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    courier_id INT,
    order_date DATETIME NOT NULL,
    delivery_date DATETIME,
    status VARCHAR(50) DEFAULT 'Pending',
    delivery_staff_id INT,
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    FOREIGN KEY (courier_id) REFERENCES courier(courier_id),
    FOREIGN KEY (delivery_staff_id) REFERENCES delivery_staff(staff_id)
);

CREATE TABLE delivery_staff (
    staff_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    phone VARCHAR(15) NOT NULL UNIQUE,
    userid VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(20),
    photo BLOB,
    assigned_order_id INT,
    delivered_data TIMESTAMP,
    FOREIGN KEY (assigned_order_id) REFERENCES orders(order_id)
);

CREATE TABLE payment (
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    payment_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    payment_method VARCHAR(50) NOT NULL,
    status VARCHAR(50) DEFAULT 'Pending',
    customer_id INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE review (
    review_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    order_id INT NOT NULL,
    staff_id INT,
    rating INT,
    comments TEXT,
    review_date DATE,
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (staff_id) REFERENCES delivery_staff(staff_id)
);