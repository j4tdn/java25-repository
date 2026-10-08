-- Phần A. Phân tích và viết các lệnh để xây dựng cơ sở dữ liệu dựa vào mô tả phía trên

-- Một nhân viên chỉ làm việc cho một phòng ban nhưng có thể làm việc cho nhiều dự án.
-- Department 1 - N Employee
-- Employee N - N Project

-- T03_PROJECT:
-- - C01_PROJECT_ID
-- - C01_PROJECT_NAME
-- - C01_PROJECT_BEGIN
-- - C01_PROJECT_END
-- - C01_PROJECT_REVENUE
-- - C01_PROJECT_MANAGER


-- T02_EMPLOYEE
-- - C02_EMPLOYEE_ID
-- - C02_EMPLOYEE_NAME,
-- - C02_ADDRESS
-- - C02_EMPLOYEE_GENDER
-- - C02_EMPLOYEE_BIRTH
-- - C02_EMPLOYEE_SALARY
-- - C02_EMPLOYEE_JOIN_DATE
-- - C02_SUPERVISOR_ID
-- - C04_DEPARTMENT_ID

-- T04_CONDUCT_PROJECT
-- - C03_CONDUCT_PROJECT_ID
-- - C03_EMPLOYEE_ID
-- - C03_PROJECT_ID
-- - C03_WORKED_HOUR

-- T01_DEPARTMENT
-- - C04_DEPARTMENT_ID
-- - C04_DEPARTMENT_NAME (UNIQUE)
-- - C04_MANAGER_ID (UNIQUE)
-- - C04_MANAGER_JOIN_DATE

CREATE DATABASE IF NOT EXISTS java25_company_management;
USE java25_company_management;

CREATE TABLE T01_DEPARTMENT(
	C01_DEPARTMENT_ID INT auto_increment PRIMARY KEY,
    C01_DEPARTMENT_NAME VARCHAR(100) UNIQUE,
    C01_MANAGER_ID INT,
    C01_MANAGER_JOIN_DATE DATE
);

-- Thiếu unique cho C01_MANAGER_ID, dùng để phân biệt FK của quan hệ 1-1 với 1-N(-2đ)

CREATE TABLE T02_EMPLOYEE(
	C02_EMPLOYEE_ID INT AUTO_INCREMENT PRIMARY KEY,
    C02_EMPLOYEE_NAME VARCHAR(100),
    C02_ADDRESS VARCHAR(255),
    C02_GENDER BIT,
    C02_DATE_OF_BIRTH DATE,
    C02_SALARY DECIMAL(10,2), 
    C02_JOIN_DATE DATE,
    C02_DEPARTMENT_ID INT,
    C02_SUPERVISOR_ID INT
);

CREATE TABLE T03_PROJECT(
	C03_PROJECT_ID INT AUTO_INCREMENT PRIMARY KEY,
    C03_PROJECT_NAME VARCHAR(100) UNIQUE,
    C03_START_DATE DATE,
    C03_END_DATE DATE,
    C03_REVENUE DECIMAL(10,2),
    C03_PROJECT_MANAGER_ID INT
);

DROP TABLE T04_CONDUCT_PROJECT;

CREATE TABLE T04_CONDUCT_PROJECT(
	C04_CONDUCT_ID INT AUTO_INCREMENT PRIMARY KEY,
    C04_EMPLOYEE_ID INT,
    C04_PROJECT_ID INT,
    C04_WORKED_HOURS DOUBLE
);

-- C04_CONDUCT_ID em làm ko sai nhưng thừa(-2đ)
-- Ở bảng N-N khi khóa chính [nhiêu hơn 1 column] bị tham chiếu nghĩa là dùng để tạo FK ở table khác thì mình mới tạo 1 column mới làm khóa chính như này em hi
-- A có giải thích bữa học rồi

ALTER TABLE T02_EMPLOYEE
ADD CONSTRAINT FK_T02_DEPARTMENT FOREIGN KEY(C02_DEPARTMENT_ID) REFERENCES T01_DEPARTMENT(C01_DEPARTMENT_ID);

ALTER TABLE T02_EMPLOYEE
ADD CONSTRAINT FK_T02_SUPERVISOR FOREIGN KEY(C02_SUPERVISOR_ID) REFERENCES T02_EMPLOYEE(C02_EMPLOYEE_ID);

ALTER TABLE T01_DEPARTMENT
ADD CONSTRAINT FK_T01_MANAGER FOREIGN KEY(C01_MANAGER_ID) REFERENCES T02_EMPLOYEE(C02_EMPLOYEE_ID);

ALTER TABLE T03_PROJECT
ADD CONSTRAINT FK_T03_PROJECT_MANAGER FOREIGN KEY(C03_PROJECT_MANAGER_ID) REFERENCES T02_EMPLOYEE(C02_EMPLOYEE_ID);

ALTER TABLE T04_CONDUCT_PROJECT
-- ADD CONSTRAINT FK_T04_EMPLOYEE FOREIGN KEY(C04_EMPLOYEE_ID) REFERENCES T02_EMPLOYEE(C02_EMPLOYEE_ID)
ADD CONSTRAINT FK_T04_PROJECT FOREIGN KEY(C04_PROJECT_ID) REFERENCES T03_PROJECT(C03_PROJECT_ID);

-- Em ALTER như này cũng được, nhưng trong dự án thì kiểu tạo TABLE nào nếu ko có quan hệ lồng như ko tạo FK được thì e nên tạo FK bên trong câu lệnh tạo TABLE luôn

-- Phần A: 50đ - 4đ = 46đ


-- Phần B. Viết các lệnh để tạo dữ liệu kiểm thử cho dự án
-- Yêu cầu: Ít nhất 5 dòng cho mỗi bảng dữ liệu

-- 	SET FOREIGN_KEY_CHECKS = 0

INSERT INTO T01_DEPARTMENT(C01_DEPARTMENT_NAME, C01_MANAGER_ID, C01_MANAGER_JOIN_DATE)
VALUES('Phòng Công nghệ thông tin', 1, '2020-01-15'),
('Phòng Tải chính Kế toán', 2, '2021-03-01'),
('Phòng Nhân sự', 3,'2019-05-10'),
('Phòng Kinh doanh',4,'2022-08-20'),
('Phòng Nghiên cứu & Phát triển',5,'2023-02-01');

INSERT INTO T02_EMPLOYEE(C02_NAME, C02_ADDRESS, C02_GENDER, C02_DATE_OF_BIRTH, C02_SALARY, C02_JOIN_DATE,C02_DEPARTMENT_ID , C02_SUPERVISOR_ID)
VALUES('Nhân viên 1', 'Hà Nội', 1, '1988-03-15', '35000000', '2018-02-01', 1, NULL),
('Nhân viên 1', 'TP HCM', 0, '1990-07-22', '28000000', '2019-06-15', 2, NULL),
('Nhân viên 1', 'Hà Nội', 0, '1995-01-30', '28000000', '2021-04-01', 4, NULL),
('Nhân viên 1', 'Đà Nẵng', 1, '1995-01-31', '25000000', '2020-01-10', 3, NULL),
('Nhân viên 1', 'Cần Thơ', 1, '1993-09-18', '39000000', '2017-08-12', 1, 1),
('Nhân viên 1', 'Hải Phòng', 0, '1997-12-12', '18000000', '2022-10-01', 1, 1);

UPDATE T02_EMPLOYEE
SET C02_EMPLOYEE_NAME = concat('Nhân viên',' ',C02_EMPLOYEE_ID);

INSERT INTO T03_PROJECT (C03_PROJECT_NAME, C03_START_DATE, C03_END_DATE, C03_REVENUE, C03_PROJECT_MANAGER_ID) 
VALUES 
    ('Chuyen doi so Ngan hang A', '2023-01-10', '2023-12-20', 15000000.00, 1),
    ('Xay dung He thong ERP', '2023-03-01', '2023-11-15', 8000000.00, 1),
    ('Ung dung Mobile Banking', '2024-02-15', '2024-09-30', 20000000.00, 2),
    ('Tuyen dung & Dao tao IT', '2023-05-01', '2023-08-31', 30000000.00, 2),
    ('Nang cap Ha tang Cloud', '2024-01-01', '2024-12-31', 12000000.00, 5);
    
INSERT INTO T04_CONDUCT_PROJECT (C04_EMPLOYEE_ID, C04_PROJECT_ID, C04_WORKED_HOURS) 
VALUES 
    (1, 1, 120.5),
    (1, 2, 80.0),
    (5, 1, 150.0),
    (5, 5, 100.0),
    (6, 2, 45.0),
    (2, 3, 160.0);
    
-- Phần B: 5đ
    
-- Phần C. Thực hiện truy vấn
-- 1. Liệt kê các dự án diễn ra trong năm *?* có số tiền thu được trên *?* triệu VND
SELECT *
FROM T03_PROJECT
WHERE YEAR(C03_START_DATE) = 2023 AND C03_REVENUE > 20000000;

-- Chưa đúng
-- Ví dụ năm e đang set là 2023 thì ví dự start_date 2022 như end_date = null hoặc >= 2023 vẫn ok

-- 2. Liệt kê các nhân viên đã tham gia hơn ?*? giờ trong các dự án, hiển thị chi tiết số giờ trong mỗi
-- dự án mà nhân viên tham gia

SELECT T02.*, T04.C04_WORKED_HOURS
FROM T02_EMPLOYEE T02 
	JOIN T04_CONDUCT_PROJECT T04 ON T02.C02_EMPLOYEE_ID = T04.C04_EMPLOYEE_ID 
    JOIN T03_PROJECT ON C04_PROJECT_ID = C03_PROJECT_ID
WHERE T04.C04_WORKED_HOURS > 100;

-- Câu này đề yêu cầu là: số giờ trong 'các' dự án, ý câu hỏi là tổng giờ trong các dự án > ?*?
-- Còn e đang làm là số giờ trong 'mỗi' dự án > ?*?
-- Như đã giải thích ở lớp, a ko trừ điểm

-- 3. Liệt kê các nhân viên có mức lương >= mức lương của người giám sát/quản lý trực tiếp nhân
-- viên đó

SELECT EMP.C02_EMPLOYEE_NAME, EMP.C02_SALARY, 
		SUP.C02_EMPLOYEE_NAME SUPERVISOR_NAME, SUP.C02_SALARY SUPERVISOR_SALARY
	FROM T02_EMPLOYEE EMP 
	JOIN T02_EMPLOYEE SUP ON EMP.C02_SUPERVISOR_ID = SUP.C02_EMPLOYEE_ID
WHERE EMP.C02_SALARY >= SUP.C02_SALARY;

-- Chính xác

-- 4. Liệt kê các phòng ban có số lượng nhân viên lớn hơn *?*
SELECT T01.C01_DEPARTMENT_ID, T01.C01_DEPARTMENT_NAME, COUNT(C02_EMPLOYEE_ID) QUANTITY
	FROM T01_DEPARTMENT T01
	JOIN T02_EMPLOYEE T02 ON C01_DEPARTMENT_ID = C02_DEPARTMENT_ID
GROUP BY C01_DEPARTMENT_ID, C01_DEPARTMENT_NAME
HAVING COUNT(C02_EMPLOYEE_ID) > 2;
-- HAVING COUNT(C02_DEPARTMENT_ID) > 2

-- Query đúng nhưng code chưa clean(-1đ)
-- Nếu đặt ALIAS thì nên viết ALIAS.COLUMN_NAME cho toàn bộ
-- Có thể dùng count(*)

-- 5. Liệt kê các nhân viên đã làm việc cho công ty hơn ?*? năm
SELECT *
	FROM T02_EMPLOYEE
WHERE (YEAR(NOW()) - YEAR(C02_JOIN_DATE)) > 5;

-- Chính xác

-- 6. Liệt kê các nhân viên vừa là trưởng phòng ban, và là quản lý dự án
SELECT DISTINCT T02.*
	FROM T02_EMPLOYEE T02
	JOIN T01_DEPARTMENT T01 ON T01.C01_MANAGER_ID = T02.C02_EMPLOYEE_ID
    JOIN T03_PROJECT T03 ON T03.C03_PROJECT_MANAGER_ID = T02.C02_EMPLOYEE_ID;

-- Chính xác
    
-- 7. Liệt kê các nhân viên quản lý nhiều hơn 1 dự án
SELECT T02.C02_EMPLOYEE_ID, T02.C02_EMPLOYEE_NAME, COUNT(C03_PROJECT_MANAGER_ID) QUANTITY
	FROM T02_EMPLOYEE T02
    JOIN T03_PROJECT T03 ON T02.C02_EMPLOYEE_ID = T03.C03_PROJECT_MANAGER_ID
GROUP BY T02.C02_EMPLOYEE_ID, T02.C02_EMPLOYEE_NAME
HAVING COUNT(C03_PROJECT_MANAGER_ID) > 1;

-- Chính xác
-- Có thể dùng count(*)

-- 8. Mỗi khi nhân viên tham gia vào dự án chúng ta cần lưu lại thông tin hay còn được gọi là log để
-- biết nhân viên đó tham gia vào dự án vào thời gian nào
-- Mỗi khi nhân viên cập nhật số giờ tham gia dự án, ta cần lưu lại thông tin thời gian cập nhật khi
-- nào, số giờ tham gia cũ, số giờ tham gia mới
-- Công việc được thực hiện tự động khi dự dữ liệu được thêm, cập nhật

CREATE TABLE IF NOT EXISTS T05_LOG_CONDUCT_PROJECT(
	C05_LOG_ID INT AUTO_INCREMENT PRIMARY KEY,
    C05_EMPLOYEE_ID INT,
    C05_PROJECT_ID INT,
    C05_OLD_WORKED_HOURS DOUBLE,
    C05_NEW_WORKED_HOURS DOUBLE,
    C05_UPDATED_AT TIMESTAMP
);

DELIMITER $$
CREATE TRIGGER LOG_UPDATE_WORKED_HOURS
AFTER UPDATE ON T04_CONDUCT_PROJECT
FOR EACH ROW
BEGIN 
	INSERT INTO T05_LOG_CONDUCT_PROJECT(C05_EMPLOYEE_ID, C05_PROJECT_ID, C05_OLD_WORKED_HOURS, C05_NEW_WORKED_HOURS, C05_UPDATED_AT)
    VALUES(NEW.C04_EMPLOYEE_ID, NEW.C04_PROJECT_ID, OLD.C04_WORKED_HOURS, NEW.C04_WORKED_HOURS, NEW.NOW());
END $$
DELIMITER ;

-- Chỗ hàm NOW em ko cần gọi NEW.NOW() chỉ cần NOW() hoặc current_timestamp()
-- Thiếu logging để biết nhân viên tham gia dự án vào thời gian nào
-- 5/10

-- Phần C: 34đ

-- Link: https://youtu.be/zTJ5XrhkZdY