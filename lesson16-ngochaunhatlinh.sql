Đề bài: Xây dựng cơ sở dữ liệu quản lý công ty để theo dõi các thông tin liên quan đến nhân viên,
phòng ban và dự án, chi tiết được mô tả như sau:
Công ty được tổ chức thành các phòng ban chức năng. Mỗi phòng ban sẽ có một tên duy nhất, một
mã số duy nhất và các nhân viên, trong đó có một nhân viên là người quản lý phòng ban đó.
Việc nhân viên quản lý phòng ban được ghi lại taị thời điểm nhân viên đó bắt đầu quản lý và được
gọi là trưởng phòng. Ta ghi nhận lại ngày nhận chức của trưởng phòng.
Công ty sẽ có nhiều dự án, một dự án có một tên duy nhất, một mã số duy nhất, ngày bắt đầu, ngày
kết thúc(hoàn thành dự án), số tiền thu được(đơn vị VNĐ) từ dự án đó.
Dự án được thực hiện bởi một hoặc nhiều nhân viên, có một nhân viên duy nhất làm quản lý dự án.
Với mỗi nhân viên chúng ta lưu giữ lại các thông tin bao gồm họ tên, mã số duy nhất, địa chỉ,
lương, giới tính, ngày sinh, ngày vào công ty.
Một nhân viên chỉ làm việc cho một phòng ban nhưng có thể làm việc cho nhiều dự án.
Chúng ta lưu giữ lại số giờ làm việc của mỗi nhân viên trên dự án mà nhân viên đó tham gia. Mỗi
nhân viên có thể có một người quản lý giám sát trực tiếp, người đó cũng là một nhân viên, nhân
viên và quản lý/giám sát của nhân viên có thể tham gia cùng/khác dự án.

Phần A. Phân tích và viết các lệnh để xây dựng cơ sở dữ liệu dựa vào mô tả phía trên
-- Tạo DataBase:
DROP DATABASE IF EXISTS company_management;
CREATE DATABASE company_management
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;
USE company_management;

-- Tạo bảng departments
CREATE TABLE departments (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL UNIQUE,
    manager_id INT NULL,
    manager_start_date DATE
);
-- Thiếu unique cho manager_id vì quan hệ 1-1

-- Tạo bảng employess
CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    salary DECIMAL(15,2) NOT NULL,
    gender ENUM('Nam', 'Nu', 'Khac'),
    birth_date DATE,
    hire_date DATE NOT NULL,

    department_id INT NOT NULL,
    supervisor_id INT NULL,

    CONSTRAINT fk_employee_department
        FOREIGN KEY (department_id)
        REFERENCES departments(department_id),

    CONSTRAINT fk_employee_supervisor
        FOREIGN KEY (supervisor_id)
        REFERENCES employees(employee_id)
);

-- Thêm Khóa ngoại trưởng phòng
ALTER TABLE departments
ADD CONSTRAINT fk_department_manager
FOREIGN KEY (manager_id)
REFERENCES employees(employee_id);

-- Tạo bảng project
CREATE TABLE projects (
    project_id INT PRIMARY KEY,
    project_name VARCHAR(150) NOT NULL UNIQUE,
    start_date DATE NOT NULL,
    end_date DATE NULL,
    revenue DECIMAL(18,2) NOT NULL DEFAULT 0,
    manager_id INT NOT NULL,

    CONSTRAINT fk_project_manager
        FOREIGN KEY (manager_id)
        REFERENCES employees(employee_id)
);

-- Tạo bảng nvien tham gia dự án
CREATE TABLE employee_project (
    employee_id INT NOT NULL,
    project_id INT NOT NULL,
    work_hours DECIMAL(8,2) NOT NULL DEFAULT 0,

    PRIMARY KEY (employee_id, project_id),

    CONSTRAINT fk_ep_employee
        FOREIGN KEY (employee_id)
        REFERENCES employees(employee_id),

    CONSTRAINT fk_ep_project
        FOREIGN KEY (project_id)
        REFERENCES projects(project_id)
);

-- Phần A: 48 điểm (thiếu 1 unique constraint)


Phần B. Viết các lệnh để tạo dữ liệu kiểm thử cho dự án
Yêu cầu: Ít nhất 5 dòng cho mỗi bảng dữ liệu
-- Thêm phòng ban
INSERT INTO departments
(department_id, department_name, manager_id, manager_start_date)
VALUES
(1, 'Cong nghe thong tin', NULL, NULL),
(2, 'Ke toan', NULL, NULL),
(3, 'Nhan su', NULL, NULL),
(4, 'Marketing', NULL, NULL),
(5, 'Kinh doanh', NULL, NULL);

-- Thêm nhân viên
INSERT INTO employees
(employee_id, full_name, address, salary, gender,
 birth_date, hire_date, department_id, supervisor_id)
VALUES

(1, 'Nguyen Van An', 'Da Nang',
30000000, 'Nam',
'1985-05-10', '2015-01-10', 1, NULL),

(2, 'Tran Thi Binh', 'Da Nang',
25000000, 'Nu',
'1987-09-15', '2016-03-20', 2, NULL),

(3, 'Le Van Cuong', 'Hoi An',
27000000, 'Nam',
'1988-04-12', '2017-07-10', 3, NULL),

(4, 'Pham Thi Dung', 'Da Nang',
26000000, 'Nu',
'1990-01-22', '2018-02-15', 4, NULL),

(5, 'Hoang Van Em', 'Hue',
28000000, 'Nam',
'1986-11-05', '2014-08-01', 5, NULL);

-- nhân viên có người giám sát
INSERT INTO employees
(employee_id, full_name, address, salary, gender,
 birth_date, hire_date, department_id, supervisor_id)
VALUES

(6, 'Vo Van Phuc', 'Da Nang',
32000000, 'Nam',
'1995-06-20', '2020-05-15', 1, 1),

(7, 'Nguyen Thi Giang', 'Hoi An',
18000000, 'Nu',
'1996-08-25', '2021-01-10', 1, 1),

(8, 'Do Van Hung', 'Da Nang',
26000000, 'Nam',
'1993-12-10', '2019-09-01', 2, 2),

(9, 'Bui Thi Lan', 'Da Nang',
20000000, 'Nu',
'1997-03-17', '2022-06-15', 4, 4),

(10, 'Tran Van Minh', 'Quang Nam',
30000000, 'Nam',
'1992-07-01', '2018-11-20', 5, 5);

-- Gán trưởng phòng 
UPDATE departments
SET manager_id = 1,
    manager_start_date = '2020-01-01'
WHERE department_id = 1;

UPDATE departments
SET manager_id = 2,
    manager_start_date = '2020-03-15'
WHERE department_id = 2;

UPDATE departments
SET manager_id = 3,
    manager_start_date = '2021-01-10'
WHERE department_id = 3;

UPDATE departments
SET manager_id = 4,
    manager_start_date = '2021-06-01'
WHERE department_id = 4;

UPDATE departments
SET manager_id = 5,
    manager_start_date = '2019-05-20'
WHERE department_id = 5;

-- Thêm dự án
INSERT INTO projects
(project_id, project_name, start_date, end_date, revenue, manager_id)
VALUES

(101, 'He thong quan ly ban hang',
 '2026-01-10', '2026-06-30',
 800000000, 1),

(102, 'Website thuong mai dien tu',
 '2026-03-01', '2026-12-30',
 1200000000, 1),

(103, 'Ung dung quan ly nhan su',
 '2025-05-01', '2026-02-15',
 450000000, 3),

(104, 'He thong cham cong',
 '2026-04-20', '2026-10-20',
 650000000, 4),

(105, 'Ung dung quan ly khach hang',
 '2025-08-01', '2025-12-31',
 900000000, 5),

(106, 'He thong bao cao doanh thu',
 '2026-06-01', '2027-01-15',
 1500000000, 2);
 
-- Nhân viên tham gia dự án
INSERT INTO employee_project
(employee_id, project_id, work_hours)
VALUES

(1, 101, 120),
(6, 101, 180),
(7, 101, 90),

(1, 102, 100),
(6, 102, 150),
(10, 102, 70),

(3, 103, 200),
(8, 103, 80),

(4, 104, 130),
(9, 104, 160),

(5, 105, 220),
(10, 105, 120),

(2, 106, 110),
(6, 106, 140);

-- Phần B: 5 điểm

Phần C. Thực hiện truy vấn
1. Liệt kê các dự án diễn ra trong năm 2026 có số tiền thu được trên 500 triệu VND

Select 
	project_id,
    project_name,
    start_date,
    end_date,
    revenue
from projects
where
	start_date <= STR_TO_DATE(CONCAT (2025, '-12-31'),'%Y-%m-%d')
    And(
		end_date Is Null
        Or end_date >= STR_TO_DATE(
			CONCAT (2026, '-01-01'),
			'%Y-%m-%d'
		)
	)
    And revenue > 500 * 1000000;
-- Có 2 vấn đề
-- 1. Sao em ko để str_to_date(value, format) mà phải dùng concat a chưa hiểu lý do
-- 2. Phần where e làm đúng chỗ > 500 triệu, còn dự án diễn ra năm 2026 có vẻ chưa đúng [diễn ra trong năm 2026 có nghĩa là start_date và end_date nằm trong khoảng 1-1 đến 31/12 năm 2026



2. Liệt kê các nhân viên đã tham gia hơn ?*? giờ trong các dự án, hiển thị chi tiết số giờ trong mỗi
dự án mà nhân viên tham gia
-- Em quên phần GROUP BY ?


3. Liệt kê các nhân viên có mức lương >= mức lương của người giám sát/quản lý trực tiếp nhân
viên đó

SELECT 
	e.employee_id,
    e.full_name AS employee_name,
    e.salary AS employee_salary,
    
    s.employee_id AS supervisor_id,
    s.full_name AS supervisor_name,
    s.salary AS supervisor_salary
From employees e
JOIN employees s
	ON e.supervisor_id = s.supervisor_id
WHERE e.salary >= s.salary;

-- Chỗ ON phải là: ON e.supervisor_id = s.employee_id
-- Khúc self FK này em cứ xem đơn giản như
-- Bảng con: Employee(employee_id, supervisor_id[FK]) [Nhân Viên] có FK trỏ đến Bảng Cha Employee(employee_id) [Giám Sát Viên hoặc Quản lý]
-- Khi join thì phải là BangCon.FK = BangCha.PK
	

4. Liệt kê các phòng ban có số lượng nhân viên lớn hơn 1

Select 
	d.department_id,
    d.department_name,
    COUNT(e.employee_id) As employee_count
	
From departments d

Join employees e
	on d.department_id = e.department_id
GROUP BY 
	d.department_id,
    d.department_name
    
Having COUNT(e.employee_id) > 1

-- Chính xác
-- Bổ sung: Chỗ count em có thể dùng count(*) cũng được

5. Liệt kê các nhân viên đã làm việc cho công ty hơn 5 năm

SELECT
    employee_id,
    full_name,
    hire_date
FROM employees
WHERE DATE_ADD(hire_date, INTERVAL 5 YEAR) < CURDATE();

-- Chính xác
	
    
6. Liệt kê các nhân viên vừa là trưởng phòng ban, và là quản lý dự án

SELECT DISTINCT
    e.employee_id,
    e.full_name,
    d.department_name

FROM employees e

JOIN departments d
    ON d.manager_id = e.employee_id

JOIN projects p
    ON p.manager_id = e.employee_id;
    
-- Chính xác

7. Liệt kê các nhân viên quản lý nhiều hơn 1 dự án

SELECT
    e.employee_id,
    e.full_name,
    COUNT(p.project_id) AS number_of_projects

FROM employees e

JOIN projects p
    ON e.employee_id = p.manager_id

GROUP BY
    e.employee_id,
    e.full_name

HAVING COUNT(p.project_id) > 1;

-- Chính xác

8. Mỗi khi nhân viên tham gia vào dự án chúng ta cần lưu lại thông tin hay còn được gọi là log để
biết nhân viên đó tham gia vào dự án vào thời gian nào
Mỗi khi nhân viên cập nhật số giờ tham gia dự án, ta cần lưu lại thông tin thời gian cập nhật khi
nào, số giờ tham gia cũ, số giờ tham gia mới
Công việc được thực hiện tự động khi dự dữ liệu được thêm, cập nhật
--

-- Phần C: 20 điểm


Link: https://youtu.be/p_ujcIO20eA