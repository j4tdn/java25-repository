
DROP DATABASE IF EXISTS lesson17_db;
CREATE DATABASE lesson17_db;
USE lesson17_db;

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
    FOREIGN KEY (cid) REFERENCES Class(id)
);

CREATE TABLE Result (
    sid INT NOT NULL,
    subject VARCHAR(50) NOT NULL,
    score DOUBLE NOT NULL,
    PRIMARY KEY (sid, subject),
    FOREIGN KEY (sid) REFERENCES Student(id)
);

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
(1, 'Math', 8.5), (1, 'Literature', 8.0), (1, 'History', 9.5),
(2, 'Math', 6.8), (2, 'Literature', 4.9), (2, 'History', 8.2),
(3, 'Math', 9.8), (3, 'Literature', 7.2), (3, 'History', 8.8),
(4, 'Math', 8.2), (4, 'Literature', 8.5), (4, 'History', 8.0),
(5, 'Math', 7.5), (5, 'Literature', 8.0), (5, 'History', 7.0),
(6, 'Math', 9.0), (6, 'Literature', 8.5), (6, 'History', 9.2);

-- Câu 1: What is primary key of Result table?
-- (sid, subject).

-- Câu 2: List name, gender and teacher name of all students.
SELECT 
    s.name AS student_name,
    CAST(s.gender AS UNSIGNED) AS gender,
    c.teacher AS teacher_name
FROM Student s
JOIN Class c ON s.cid = c.id;

-- Câu 3: List teacher name and number of all student in class 12C.
SELECT 
    c.teacher,
    COUNT(s.id) AS number_of_students
FROM Class c
LEFT JOIN Student s ON c.id = s.cid
WHERE c.name = '12C'
GROUP BY c.id, c.teacher;

-- Câu 4: List the class name and number of the students who have good at Math (score>=8) and good at Literature (score>=8).
SELECT 
    c.name AS class_name,
    COUNT(good_students.sid) AS number_of_good_students
FROM Class c
LEFT JOIN Student s ON c.id = s.cid
LEFT JOIN (
    SELECT sid
    FROM Result
    WHERE (subject = 'Math' AND score >= 8)
       OR (subject = 'Literature' AND score >= 8)
    GROUP BY sid
    HAVING COUNT(DISTINCT subject) = 2
) good_students ON s.id = good_students.sid
GROUP BY c.id, c.name;