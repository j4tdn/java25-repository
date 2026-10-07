-- Employee
-- Department
-- Project

-- Phần A. Phân tích và viết các lệnh để xây dựng cơ sở dữ liệu dựa vào mô tả phía trên
-- Database
DROP DATABASE IF EXISTS java25_company_management;
CREATE DATABASE IF NOT EXISTS java25_company_management CHAR SET utf8mb4;

USE java25_company_management;

-- Table & Columns
CREATE TABLE T1001_DEPARTMENT (
	C1001_DEPARTMENT_ID INT AUTO_INCREMENT PRIMARY KEY,
    C1001_DEPARTMENT_NAME VARCHAR(255) NOT NULL,
    C1001_DMANAGER_ID INT NOT NULL, -- Quan hệ quản lý 1-1 giữa Phòng Ban và Nhân Viên --
    C1001_MANAGER_DATE_START DATE NOT NULL DEFAULT(curdate()),
    CONSTRAINT UNQ_DEPARTMENT_NAME UNIQUE(C1001_DEPARTMENT_NAME),
    CONSTRAINT UNQ_DMANAGER_ID UNIQUE(C1001_DMANAGER_ID)
);

CREATE TABLE T1002_EMPLOYEE(
	C1002_EMPLOYEE_ID INT AUTO_INCREMENT PRIMARY KEY,
    C1002_EMPLOYEE_NAME VARCHAR(255) NOT NULL,
    C1002_ADDRESS TEXT NOT NULL,
    C1002_SALARY DOUBLE NOT NULL,
    C1002_GENDER BIT(1) NOT NULL,
    C1002_DAY_OF_BIRTH DATE NOT NULL,
    C1002_WORKING_DATE_START DATE NOT NULL,
    C1002_MANAGER_ID INT, -- Quan hệ 1-N quản lý giám sát nhân viên [self]
    C1002_DEPARTMENT_ID INT NOT NULL, -- Quan hệ 1-N phòng ban chứa nhân viên
    CONSTRAINT FK_T1002_SELF_MANAGEMENT FOREIGN KEY (C1002_MANAGER_ID)    REFERENCES T1002_EMPLOYEE(C1002_EMPLOYEE_ID),
    CONSTRAINT FK_T1002_T1001           FOREIGN KEY (C1002_DEPARTMENT_ID) REFERENCES T1001_DEPARTMENT(C1001_DEPARTMENT_ID)
);

ALTER TABLE T1001_DEPARTMENT ADD
CONSTRAINT FK_T1001_T1002 FOREIGN KEY (C1001_DMANAGER_ID) REFERENCES T1002_EMPLOYEE(C1002_EMPLOYEE_ID);

CREATE TABLE T1003_PROJECT(
	C1003_PROJECT_ID INT AUTO_INCREMENT PRIMARY KEY,
    C1003_PROJECT_NAME VARCHAR(255) NOT NULL,
    C1003_DATE_START DATE NOT NULL,
    C1003_DATE_END DATE NOT NULL,
    C1003_REVENUE INT NOT NULL,
    C1003_PMANAGER_ID INT NOT NULL, -- Quan hệ quản lý 1-N trưởng quản lý dự án
    CONSTRAINT UNQ_PROJECT_NAME UNIQUE(C1003_PROJECT_NAME),
	CONSTRAINT FK_T1003_T1002 FOREIGN KEY (C1003_PMANAGER_ID) REFERENCES T1002_EMPLOYEE(C1002_EMPLOYEE_ID)
);

-- Quan hệ N-N giữa dự án và nhân viên thực hiện
CREATE TABLE T1004_PROJECT_MANAGEMENT (
	C1004_PROJECT_ID INT,
    C1004_EMPLOYEE_ID INT,
    C1004_WORKING_HOURS INT NOT NULL,
    PRIMARY KEY (C1004_PROJECT_ID, C1004_EMPLOYEE_ID),
    CONSTRAINT FK_T1004_T1003 FOREIGN KEY (C1004_PROJECT_ID) REFERENCES T1003_PROJECT(C1003_PROJECT_ID),
    CONSTRAINT FK_T1004_T1002 FOREIGN KEY (C1004_EMPLOYEE_ID) REFERENCES T1002_EMPLOYEE(C1002_EMPLOYEE_ID)
);


-- Phần B. Viết các lệnh để tạo dữ liệu kiểm thử cho dự án
-- Yêu cầu: Ít nhất 5 dòng cho mỗi bảng dữ liệu
-- 1. Disable foreign key checks to bypass constraint restrictions
SET FOREIGN_KEY_CHECKS = 0;

-- 2. Truncate all tables in the correct dependency order
TRUNCATE TABLE T1004_PROJECT_MANAGEMENT;
TRUNCATE TABLE T1003_PROJECT;
TRUNCATE TABLE T1001_DEPARTMENT;
TRUNCATE TABLE T1002_EMPLOYEE;

-- 3. Re-enable foreign key checks
SET FOREIGN_KEY_CHECKS = 1;

-- Disable foreign key checks temporarily to handle circular dependencies
SET FOREIGN_KEY_CHECKS = 0;

-- ==========================================
-- 1. INSERT DATA INTO T1002_EMPLOYEE (10 rows)
-- ==========================================
INSERT INTO T1002_EMPLOYEE (C1002_EMPLOYEE_ID, C1002_EMPLOYEE_NAME, C1002_ADDRESS, C1002_SALARY, C1002_GENDER, C1002_DAY_OF_BIRTH, C1002_WORKING_DATE_START, C1002_MANAGER_ID, C1002_DEPARTMENT_ID) VALUES
(1, 'Nguyen Van An', '123 Le Loi, Hanoi', 25000000, b'1', '1985-05-12', '2015-03-01', NULL, 1),
(2, 'Tran Thi Bich', '456 Nguyen Hue, Da Nang', 22000000, b'0', '1990-08-22', '2017-06-15', 1, 2),
(3, 'Le Van Cuong', '789 Tran Hung Dao, HCMC', 20000000, b'1', '1992-02-14', '2018-01-10', 1, 3),
(4, 'Pham Thi Dung', '321 Le Duan, Hue', 18000000, b'0', '1994-11-05', '2019-07-20', 2, 4),
(5, 'Hoang Van Em', '654 Phan Chu Trinh, Can Tho', 19000000, b'1', '1991-07-19', '2019-09-01', 2, 5),
(6, 'Vu Thi Phuong', '987 Hung Vuong, Hai Phong', 21000000, b'0', '1988-12-30', '2016-11-15', 3, 6),
(7, 'Ngo Van Giang', '111 Dien Bien Phu, Nha Trang', 17000000, b'1', '1995-04-25', '2021-02-10', 3, 7),
(8, 'Bui Thi Hoa', '222 Cach Mang Thang 8, Bien Hoà', 16000000, b'0', '1996-09-18', '2021-05-05', 4, 8),
(9, 'Dang Van Hung', '333 Vo Van Tan, Vung Tau', 23000000, b'1', '1989-03-03', '2017-08-12', 4, 9),
(10, 'Do Thi Lan', '444 Pasteur, Da Lat', 17500000, b'0', '1993-10-10', '2020-04-18', 5, 10);

-- ==========================================
-- 2. INSERT DATA INTO T1001_DEPARTMENT (10 rows)
-- ==========================================
INSERT INTO T1001_DEPARTMENT (C1001_DEPARTMENT_ID, C1001_DEPARTMENT_NAME, C1001_DMANAGER_ID, C1001_MANAGER_DATE_START) VALUES
(1, 'Human Resources', 1, '2020-01-01'),
(2, 'Information Technology', 2, '2020-01-01'),
(3, 'Finance & Accounting', 3, '2020-01-01'),
(4, 'Marketing', 4, '2021-03-15'),
(5, 'Sales', 5, '2021-03-15'),
(6, 'Research & Development', 6, '2019-06-01'),
(7, 'Operations', 7, '2022-01-10'),
(8, 'Legal', 8, '2022-05-20'),
(9, 'Customer Support', 9, '2021-08-01'),
(10, 'Quality Assurance', 10, '2022-02-15');

-- ==========================================
-- 3. INSERT DATA INTO T1003_PROJECT (10 rows)
-- ==========================================
INSERT INTO T1003_PROJECT (C1003_PROJECT_ID, C1003_PROJECT_NAME, C1003_DATE_START, C1003_DATE_END, C1003_REVENUE, C1003_PMANAGER_ID) VALUES
(1, 'Alpha Cloud Migration', '2026-01-10', '2026-06-30', 500000000, 2),
(2, 'Beta E-Commerce Platform', '2026-02-01', '2026-12-31', 1200000000, 3),
(3, 'Gamma Mobile App', '2026-03-15', '2026-09-15', 350000000, 6),
(4, 'Delta AI Analytics', '2026-01-01', '2026-10-31', 800000000, 2),
(5, 'Epsilon CRM Upgrade', '2025-04-01', '2026-08-31', 250000000, 1),
(6, 'Zeta Security Audit', '2026-05-01', '2026-07-31', 150000000, 6),
(7, 'Eta Marketing Campaign Q3', '2026-06-01', '2026-09-30', 400000000, 4),
(8, 'Theta ERP Integration', '2026-01-15', '2028-11-30', 950000000, 3),
(9, 'Iota Customer Portal', '2026-03-01', '2026-08-15', 300000000, 5),
(10, 'Kappa Infrastructure Overhaul', '2026-02-15', '2026-10-15', 600000000, 2);

-- =======================================================
-- 4. INSERT DATA INTO T1004_PROJECT_MANAGEMENT (10 rows)
-- =======================================================
INSERT INTO T1004_PROJECT_MANAGEMENT (C1004_PROJECT_ID, C1004_EMPLOYEE_ID, C1004_WORKING_HOURS) VALUES
(1, 2, 160),
(1, 3, 120),
(2, 3, 200),
(2, 6, 140),
(3, 6, 180),
(4, 2, 150),
(5, 1, 90),
(6, 7, 100),
(7, 4, 130),
(8, 5, 110);

-- Re-enable foreign key checks
SET FOREIGN_KEY_CHECKS = 1;

-- Quick select
SELECT * FROM t1001_department;
SELECT * FROM t1002_employee;
SELECT * FROM t1003_project;
SELECT * FROM t1004_project_management;

-- Phần C. Thực hiện truy vấn
-- 1. Liệt kê các dự án diễn ra trong năm *?* có số tiền thu được trên *?* triệu VND
SELECT *
  FROM t1003_project
  WHERE 2026 BETWEEN YEAR(C1003_DATE_START) AND YEAR(C1003_DATE_END)
    AND C1003_REVENUE > 800000000;

-- 2. Liệt kê các nhân viên đã tham gia hơn ?*?  giờ trong các dự án, hiển thị chi tiết số giờ trong mỗi dự án mà nhân viên tham gia
SELECT C1004_EMPLOYEE_ID EMPLOYEE_ID,
       group_concat(C1004_PROJECT_ID,':',C1004_WORKING_HOURS SEPARATOR ', ') WORKING_HOURS_DETAILS,
       SUM(C1004_WORKING_HOURS) WORKING_HOURS_TOTAL
  FROM t1004_project_management
 GROUP BY C1004_EMPLOYEE_ID
 HAVING SUM(C1004_WORKING_HOURS) > 120;

WITH QualifiedEmployees AS (
    -- Bước 1: Lọc ra các nhân viên có tổng số giờ tham gia > ? (Ví dụ: > 150 giờ)
    SELECT C1004_EMPLOYEE_ID
    FROM T1004_PROJECT_MANAGEMENT
    GROUP BY C1004_EMPLOYEE_ID
    HAVING SUM(C1004_WORKING_HOURS) > 150
)
-- Bước 2: Lấy thông tin chi tiết các dự án của những nhân viên đó
SELECT 
    e.C1002_EMPLOYEE_ID AS 'Mã Nhân Viên',
    e.C1002_EMPLOYEE_NAME AS 'Tên Nhân Viên',
    p.C1003_PROJECT_ID AS 'Mã Dự Án',
    p.C1003_PROJECT_NAME AS 'Tên Dự Án',
    pm.C1004_WORKING_HOURS AS 'Số Giờ Làm Việc'
FROM 
    QualifiedEmployees qe
JOIN 
    T1002_EMPLOYEE e ON qe.C1004_EMPLOYEE_ID = e.C1002_EMPLOYEE_ID
JOIN 
    T1004_PROJECT_MANAGEMENT pm ON e.C1002_EMPLOYEE_ID = pm.C1004_EMPLOYEE_ID
JOIN 
    T1003_PROJECT p ON pm.C1004_PROJECT_ID = p.C1003_PROJECT_ID;

-- 3. Liệt kê các nhân viên có mức lương >= mức lương của người giám sát/quản lý trực tiếp nhân viên đó
SELECT emp.C1002_EMPLOYEE_ID EMPLOYEE_ID,
       emp.C1002_EMPLOYEE_NAME EMPLOYEE_NAME,
       format(emp.C1002_SALARY, 0) EMPLOYEE_SALARY,
       '---' DIVISION,
       mng.C1002_EMPLOYEE_ID MANAGER_ID,
       mng.C1002_EMPLOYEE_NAME MANAGER_NAME,
       format(mng.C1002_SALARY, 0) MANAGER_SALARY
  FROM t1002_employee emp
  JOIN t1002_employee mng
    ON emp.C1002_MANAGER_ID = mng.C1002_EMPLOYEE_ID
 WHERE emp.C1002_SALARY >= mng.C1002_SALARY;

-- 4. Liệt kê các phòng ban có số lượng nhân viên lớn hơn *?*
SELECT C1002_DEPARTMENT_ID DEPARTMENT_ID,
       COUNT(*) NUMBER_OF_EMPLOYEES
  FROM t1002_employee
 GROUP BY C1002_DEPARTMENT_ID
 HAVING COUNT(*) > 2;

-- 5. Liệt kê các nhân viên đã làm việc cho công ty hơn ?*? năm 
-- Cách 1:
SELECT C1002_EMPLOYEE_ID EMPLOYEE_ID,
       C1002_EMPLOYEE_NAME EMPLOYEE_NAME,
       C1002_WORKING_DATE_START WORKING_DATE_START,
       curdate() `CURRENT_DATE`,
       TIMESTAMPDIFF(YEAR, C1002_WORKING_DATE_START, CURDATE()) WORKED_YEARS
  FROM t1002_employee
 WHERE TIMESTAMPDIFF(YEAR, C1002_WORKING_DATE_START, CURDATE()) >= 8;
  
-- Cách 2:
SELECT C1002_EMPLOYEE_ID EMPLOYEE_ID,
       C1002_EMPLOYEE_NAME EMPLOYEE_NAME,
       C1002_WORKING_DATE_START WORKING_DATE_START,
       curdate() `CURRENT_DATE`
  FROM t1002_employee
 WHERE C1002_WORKING_DATE_START <= DATE_SUB(CURDATE(), INTERVAL 8 YEAR);
-- 6. Liệt kê các nhân viên vừa là trưởng phòng ban, và là quản lý dự án
-- UNION: hợp
-- INTERSECT: giao(MYSQL không hỗ trợ)
SELECT *
  FROM t1002_employee emp
  JOIN t1001_department dep
    ON emp.C1002_EMPLOYEE_ID = dep.C1001_DMANAGER_ID
  JOIN t1003_project pro
    ON emp.C1002_EMPLOYEE_ID = pro.C1003_PMANAGER_ID;

-- 7. Liệt kê các nhân viên quản lý nhiều hơn 1 dự án
SELECT pro.C1003_PMANAGER_ID PMANAGER_ID,
       emp.C1002_EMPLOYEE_NAME PMANAGER_NAME,
       COUNT(*) NUMBER_OF_PROJECTS 
  FROM t1002_employee emp
  JOIN t1003_project pro
    ON emp.C1002_EMPLOYEE_ID = pro.C1003_PMANAGER_ID
 GROUP BY pro.C1003_PMANAGER_ID
 HAVING COUNT(*) > 1;

-- 8.
-- Mỗi khi nhân viên tham gia vào dự án chúng ta cần lưu lại thông tin hay còn được gọi là log để biết nhân viên đó tham gia vào dự án vào thời gian nào
-- TRIGGER: AFTER INSERT

-- Mỗi khi nhân viên cập nhật số giờ tham gia dự án, ta cần lưu lại thông tin thời gian cập nhật khi nào, số giờ tham gia cũ, số giờ tham gia mới
-- TRIGGER: AFTER UPDATE

-- Công việc được thực hiện tự động khi dự dữ liệu được thêm, cập nhật

-- Nên có thêm 1 AUTO_INCREMENT column
CREATE TABLE t1004_project_management_trace (
	C1004_PROJECT_ID_TCE INT,       
    C1004_EMPLOYEE_ID_TCE INT,      
    C1004_ASSIGNMENT_TIME_TCE DATETIME, -- 8A
    C1004_WORKING_HOURS_OLD_TCE INT,    -- 8B
    C1004_WORKING_HOURS_NEW_TCE INT,    -- 8B
    C1004_UPDATING_TIME DATETIME,       -- 8B
    C1004_TRIGGER_TYPE VARCHAR(100)
);

-- 8A
DROP TRIGGER trigger_t1004_after_insert;

DELIMITER $$

CREATE TRIGGER trigger_t1004_after_insert
AFTER INSERT
ON t1004_project_management FOR EACH ROW
BEGIN
    INSERT INTO t1004_project_management_trace(C1004_PROJECT_ID_TCE, C1004_EMPLOYEE_ID_TCE, C1004_ASSIGNMENT_TIME_TCE, C1004_TRIGGER_TYPE)
    VALUES(NEW.C1004_PROJECT_ID, NEW.C1004_EMPLOYEE_ID, current_timestamp(), 'INSERT');
END $$

DELIMITER ;

SELECT * FROM t1004_project_management;
SELECT * FROM t1004_project_management_trace;

INSERT INTO T1004_PROJECT_MANAGEMENT (C1004_PROJECT_ID, C1004_EMPLOYEE_ID, C1004_WORKING_HOURS) VALUES
(1, 4, 140),
(2, 8, 280);


-- 8B
DELIMITER $$

DROP TRIGGER trigger_t1004_after_update;

DELIMITER $$

CREATE TRIGGER trigger_t1004_after_update
AFTER UPDATE ON t1004_project_management FOR EACH ROW
BEGIN
    IF OLD.C1004_WORKING_HOURS <> NEW.C1004_WORKING_HOURS THEN
        INSERT INTO t1004_project_management_trace(
			C1004_PROJECT_ID_TCE, C1004_EMPLOYEE_ID_TCE, C1004_WORKING_HOURS_OLD_TCE, 
			C1004_WORKING_HOURS_NEW_TCE, C1004_UPDATING_TIME, C1004_TRIGGER_TYPE
        ) 
        VALUES (
            NEW.C1004_PROJECT_ID, 
            NEW.C1004_EMPLOYEE_ID, 
            OLD.C1004_WORKING_HOURS, -- Số giờ trước khi cập nhật
            NEW.C1004_WORKING_HOURS,  -- Số giờ sau khi cập nhật
			current_timestamp(),
            'UPDATE'
        );
    END IF;
END $$

DELIMITER ;

SELECT * FROM t1004_project_management;
SELECT * FROM t1004_project_management_trace;

UPDATE t1004_project_management
   SET C1004_WORKING_HOURS = 111
 WHERE C1004_PROJECT_ID = 5
   AND C1004_EMPLOYEE_ID = 1;

-- Youtube Link:


