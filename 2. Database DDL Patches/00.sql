-- Xóa cơ sở dữ liệu
DROP DATABASE IF EXISTS java25_shopping;

-- Tạo cở sở dữ liệu
CREATE DATABASE IF NOT EXISTS java25_shopping CHAR SET utf8mb4;

-- Thiết lập java25_shopping như là default database
USE java25_shopping;

-- KDL

-- Số nguyên: INT
-- Số thực: DECIMAL(p, s)
--        : DECIMAL(17, 2)

-- Chuỗi: VARCHAR(255)
--      : SĐT, Màu sắc VARCHAR(50)
--      : Không giới hạn TEXT

-- DML ==> test data, demo