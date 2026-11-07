

DROP DATABASE IF EXISTS lesson17_ngochaunhatlinh;
CREATE DATABASE lesson17_ngochaunhatlinh CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE lesson17_ngochaunhatlinh;


-- 1. DDL: CREATE TABLES


CREATE TABLE Class (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    teacher VARCHAR(100) NOT NULL
);

CREATE TABLE Student (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    gender BIT(1) NOT NULL,
    cid INT NOT NULL,
    CONSTRAINT fk_student_class FOREIGN KEY (cid) REFERENCES Class(id)
);

CREATE TABLE Result (
    sid INT NOT NULL,
    subject VARCHAR(50) NOT NULL,
    score DOUBLE NOT NULL,
    PRIMARY KEY (sid, subject),
    CONSTRAINT fk_result_student FOREIGN KEY (sid) REFERENCES Student(id)
);


-- 2. DML: INSERT SAMPLE & TEST DATA


INSERT INTO Class (id, name, teacher) VALUES
(1, '12A', 'GV1'),
(2, '12B', 'GV2'),
(3, '12C', 'GV3');

INSERT INTO Student (id, name, gender, cid) VALUES
(1, 'LVT 1', b'0', 2),
(2, 'LVT 2', b'1', 1),
(3, 'LVT 3', b'0', 2),
(4, 'LVT 4', b'1', 1),
(5, 'LVT 5', b'0', 3),
(6, 'LVT 6', b'1', 3);

INSERT INTO Result (sid, subject, score) VALUES
-- Student 1 (Class 12B): Math = 8.0, Literature = 7.0, History = 9.5 (Avg = 8.17)
(1, 'Math', 8.0),
(1, 'Literature', 7.0),
(1, 'History', 9.5),

-- Student 2 (Class 12A): Math = 6.8, Literature = 4.9, History = 8.2 (Avg = 6.63)
(2, 'Math', 6.8),
(2, 'Literature', 4.9),
(2, 'History', 8.2),

-- Student 3 (Class 12B): Math = 9.8, Literature = 7.2, History = 8.8 (Avg = 8.60)
(3, 'Math', 9.8),
(3, 'Literature', 7.2),
(3, 'History', 8.8),

-- Student 4 (Class 12A): Math = 8.5, Literature = 8.2, History = 8.0 (Avg = 8.23, Math >= 8 & Literature >= 8)
(4, 'Math', 8.5),
(4, 'Literature', 8.2),
(4, 'History', 8.0),

-- Student 5 (Class 12C): Math = 9.0, Literature = 8.5, History = 9.2 (Avg = 8.90, Math >= 8 & Literature >= 8)
(5, 'Math', 9.0),
(5, 'Literature', 8.5),
(5, 'History', 9.2),

-- Student 6 (Class 12C): Math = 8.0, Literature = 8.0, History = 7.5 (Avg = 7.83, Math >= 8 & Literature >= 8)
(6, 'Math', 8.0),
(6, 'Literature', 8.0),
(6, 'History', 7.5);


-- 3. DATABASE QUESTIONS


-- Question 1: What is primary key of Result table?
-- Trả lời:
-- Khóa chính (Primary Key) của bảng Result là khóa phức hợp (Composite Key) gồm 2 cột: (sid, subject).
-- Giải thích: Một học sinh (sid) học nhiều môn khác nhau và một môn học (subject) có nhiều học sinh theo học,
-- nên cặp (sid, subject) mới xác định duy nhất điểm của một học sinh ở một môn học cụ thể.

-- Question 2: List name, gender and teacher name of all students.
SELECT 
    s.name AS student_name,
    CAST(s.gender AS UNSIGNED) AS gender,
    c.teacher AS teacher_name
FROM Student s
JOIN Class c ON s.cid = c.id;

-- Question 3: List teacher name and number of all student in class 12C.
SELECT 
    c.teacher AS teacher_name,
    COUNT(s.id) AS number_of_students
FROM Class c
LEFT JOIN Student s ON c.id = s.cid
WHERE c.name = '12C'
GROUP BY c.id, c.teacher;

-- Question 4: List the class name and number of the students who have good at Math (score>=8)
-- and good at Literature (score>=8).
SELECT 
    c.name AS class_name,
    COUNT(s.id) AS number_of_good_students
FROM Class c
JOIN Student s ON c.id = s.cid
JOIN Result r_math ON s.id = r_math.sid AND r_math.subject = 'Math' AND r_math.score >= 8
JOIN Result r_lit  ON s.id = r_lit.sid  AND r_lit.subject = 'Literature' AND r_lit.score >= 8
GROUP BY c.id, c.name;
