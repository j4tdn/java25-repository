-- =====================================================================
-- Lesson 17 - Database & JDBC test
-- Target: MySQL 8 (MySQL Workbench)
-- =====================================================================

DROP DATABASE IF EXISTS lesson17;
CREATE DATABASE lesson17 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE lesson17;

-- ---------------------------------------------------------------------
-- DDL
-- ---------------------------------------------------------------------
CREATE TABLE Class (
    id      INT          NOT NULL,
    name    VARCHAR(50)  NOT NULL,
    teacher VARCHAR(100) NOT NULL,
    CONSTRAINT pk_class PRIMARY KEY (id)
);

CREATE TABLE Student (
    id     INT          NOT NULL,
    name   VARCHAR(100) NOT NULL,
    gender BIT(1)       NOT NULL,          -- assumption: 1 = Male, 0 = Female
    cid    INT          NOT NULL,
    CONSTRAINT pk_student PRIMARY KEY (id),
    CONSTRAINT fk_student_class FOREIGN KEY (cid) REFERENCES Class(id)
);

-- Q1. Primary key of Result is the COMPOSITE key (sid, subject):
--     one student has exactly one score per subject, so neither sid nor
--     subject alone is unique, but the pair is.
CREATE TABLE Result (
    sid     INT          NOT NULL,
    subject VARCHAR(50)  NOT NULL,
    score   DECIMAL(4,2) NOT NULL,
    CONSTRAINT pk_result PRIMARY KEY (sid, subject),
    CONSTRAINT fk_result_student FOREIGN KEY (sid) REFERENCES Student(id),
    CONSTRAINT ck_result_subject CHECK (subject IN ('Math', 'Literature', 'History')),
    CONSTRAINT ck_result_score   CHECK (score BETWEEN 0 AND 10)
);

-- ---------------------------------------------------------------------
-- DML - test data
-- Class and Student rows are taken from the sample.
-- Result: the sample rows for sid 1..6 are kept; rows for sid 7..9 are
-- dropped (those students do not exist). The missing subjects are filled
-- in so every student has all 3 scores and every question returns data.
-- ---------------------------------------------------------------------
INSERT INTO Class (id, name, teacher) VALUES
(1, '12A', 'GV1'),
(2, '12B', 'GV2'),
(3, '12C', 'GV3');

INSERT INTO Student (id, name, gender, cid) VALUES
(1, 'LVT 1', 0, 2),
(2, 'LVT 2', 1, 1),
(3, 'LVT 3', 0, 2),
(4, 'LVT 4', 1, 1),
(5, 'LVT 5', 0, 3),
(6, 'LVT 6', 1, 3);

INSERT INTO Result (sid, subject, score) VALUES
(1, 'Math', 8.00), (1, 'Literature', 8.50), (1, 'History', 8.00),
(2, 'Math', 9.00), (2, 'Literature', 7.00), (2, 'History', 8.50),
(3, 'Math', 9.50), (3, 'Literature', 8.00), (3, 'History', 9.50),
(4, 'Math', 6.80), (4, 'Literature', 8.00), (4, 'History', 7.50),
(5, 'Math', 8.50), (5, 'Literature', 4.90), (5, 'History', 7.00),
(6, 'Math', 9.00), (6, 'Literature', 8.50), (6, 'History', 8.20);

-- ---------------------------------------------------------------------
-- Q2. List name, gender and teacher name of all students
-- ---------------------------------------------------------------------
SELECT s.name,
       CASE s.gender WHEN 1 THEN 'Male' ELSE 'Female' END AS gender,
       c.teacher
FROM Student s
JOIN Class c ON c.id = s.cid
ORDER BY s.id;

-- ---------------------------------------------------------------------
-- Q3. Teacher name and number of students in class 12C
--     (LEFT JOIN so an empty class still returns 0)
-- ---------------------------------------------------------------------
SELECT c.teacher,
       COUNT(s.id) AS number_of_students
FROM Class c
LEFT JOIN Student s ON s.cid = c.id
WHERE c.name = '12C'
GROUP BY c.id, c.teacher;

-- ---------------------------------------------------------------------
-- Q4. Class name and number of students with Math >= 8 AND Literature >= 8
-- ---------------------------------------------------------------------
SELECT c.name AS class_name,
       COUNT(*) AS number_of_students
FROM Class c
JOIN Student s ON s.cid = c.id
JOIN Result m  ON m.sid = s.id AND m.subject = 'Math'       AND m.score >= 8
JOIN Result l  ON l.sid = s.id AND l.subject = 'Literature' AND l.score >= 8
GROUP BY c.id, c.name
ORDER BY c.name;
