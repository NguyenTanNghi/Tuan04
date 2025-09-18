CREATE
DATABASE IF NOT EXISTS shopphonedb
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE
shopphonedb;

-- Bảng phone
CREATE TABLE phone
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(100)   NOT NULL,
    price DECIMAL(15, 2) NOT NULL,
    image VARCHAR(255) NULL
);

-- Bảng cart (nếu muốn lưu giỏ hàng của user trong DB)
CREATE TABLE cart
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    user_id    INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Bảng item_cart (chi tiết giỏ hàng)
CREATE TABLE item_cart
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    cart_id  INT NOT NULL,
    phone_id INT NOT NULL,
    quantity INT NOT NULL DEFAULT 1,
    FOREIGN KEY (cart_id) REFERENCES cart (id) ON DELETE CASCADE,
    FOREIGN KEY (phone_id) REFERENCES phone (id) ON DELETE CASCADE
);

-- Thêm dữ liệu mẫu vào phone
INSERT INTO phone (name, price, image)
VALUES ('Product 1', 50000, 'image1.png'),
       ('Product 2', 20000, 'image2.png'),
       ('Product 3', 40000, 'image3.jpeg'),
       ('Product 4', 80000, 'image4.jpeg'),
       ('Product 5', 100000, 'image5.png');
