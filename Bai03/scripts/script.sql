-- Tạo cơ sở dữ liệu
CREATE
DATABASE QUANLYDIENTHOAI;


-- Sử dụng cơ sở dữ liệu vừa tạo
USE
QUANLYDIENTHOAI;


-- Tạo bảng Nhà Cung Cấp
CREATE TABLE NHACUNGCAP
(
    MANCC       NVARCHAR(10) PRIMARY KEY,
    TENNHACC    NVARCHAR(100) NOT NULL,
    DIACHI      NVARCHAR(255),
    SODIENTHOAI NVARCHAR(15)
);


-- Tạo bảng Điện Thoại
CREATE TABLE DIENTHOAI
(
    MADT       NVARCHAR(10) PRIMARY KEY,
    TENDT      NVARCHAR(100) NOT NULL,
    NAMSANXUAT INT,
    CAUHINH    NVARCHAR(255),
    MANCC      NVARCHAR(10),
    HINHANH    NVARCHAR(255),
    FOREIGN KEY (MANCC) REFERENCES NHACUNGCAP (MANCC)
);

-- Chèn dữ liệu mẫu
INSERT INTO NHACUNGCAP (MANCC, TENNHACC, DIACHI, SODIENTHOAI)
VALUES ('SS', N'Samsung Việt Nam', N'Quận 9, TP.HCM', '0123456789'),
       ('AP', N'Apple Inc.', N'California, USA', '0987654321'),
       ('XI', N'Xiaomi', N'Bắc Kinh, Trung Quốc', '0112233445');

INSERT INTO DIENTHOAI (MADT, TENDT, NAMSANXUAT, CAUHINH, MANCC, HINHANH)
VALUES ('SSGLS23', N'Samsung Galaxy S23 Ultra', 2023, N'Snapdragon 8 Gen 2, 12GB RAM, 256GB ROM', 'SS',
        'galaxy_s23.jpg'),
       ('IP15PM', N'iPhone 15 Pro Max', 2023, N'Apple A17 Pro, 8GB RAM, 256GB ROM', 'AP', 'iphone_15.jpg'),
       ('XI13T', N'Xiaomi 13T Pro', 2023, N'Dimensity 9200+, 12GB RAM, 512GB ROM', 'XI', 'xiaomi_13t.jpg');