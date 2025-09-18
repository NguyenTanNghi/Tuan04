-- 1. TẠO CƠ SỞ DỮ LIỆU
CREATE
DATABASE IF NOT EXISTS QUANLYDANHMUC CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 2. SỬ DỤNG CƠ SỞ DỮ LIỆU
USE
QUANLYDANHMUC;

-- 3. TẠO BẢNG DANHMUC
CREATE TABLE DANHMUC
(
    MADM        VARCHAR(10) PRIMARY KEY,
    TENDANHMUC  VARCHAR(100) NOT NULL,
    NGUOIQUANLY VARCHAR(100),
    GHICHU      TEXT
);

-- 4. TẠO BẢNG TINTUC
CREATE TABLE TINTUC
(
    MATT      VARCHAR(10) PRIMARY KEY,
    TIEUDE    VARCHAR(255) NOT NULL,
    NOIDUNGTT TEXT,
    LIENKET   VARCHAR(255),
    MADM      VARCHAR(10),
    FOREIGN KEY (MADM) REFERENCES DANHMUC (MADM) ON DELETE CASCADE
);

-- 5. THÊM DỮ LIỆU MẪU
INSERT INTO DANHMUC (MADM, TENDANHMUC, NGUOIQUANLY)
VALUES ('TT', 'Tin tức Thời sự', 'Nguyễn Văn A'),
       ('TG', 'Thế giới', 'Trần Thị B'),
       ('CN', 'Công nghệ', 'Lê Văn C');

INSERT INTO TINTUC (MATT, TIEUDE, NOIDUNGTT, LIENKET, MADM)
VALUES ('TT01', 'Bão số 5 sắp vào biển Đông', 'Nội dung chi tiết về cơn bão số 5, dự báo sức gió và hướng di chuyển.',
        'http://example.com/bao-so-5', 'TT'),
       ('TT02', 'Giá xăng tăng mạnh từ hôm nay', 'Bộ Công Thương đã điều chỉnh giá xăng dầu bán lẻ trong nước.',
        'http://example.com/gia-xang', 'TT'),
       ('CN01', 'Apple ra mắt sản phẩm mới',
        'Gã khổng lồ công nghệ Apple vừa giới thiệu dòng sản phẩm mới với nhiều cải tiến.',
        'http://example.com/apple-new', 'CN'),
       ('TG01', 'Căng thẳng leo thang tại Trung Đông',
        'Tình hình chính trị tại khu vực Trung Đông đang có những diễn biến phức tạp.', 'http://example.com/trung-dong',
        'TG');