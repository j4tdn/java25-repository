CREATE DATABASE IF NOT EXISTS lesson17_db;
USE lesson17_db;

DROP TABLE IF EXISTS Result;
DROP TABLE IF EXISTS Student;
DROP TABLE IF EXISTS Class;

CREATE TABLE Class (
    id INT PRIMARY KEY,
    name VARCHAR(20),
    teacher VARCHAR(50)
);

CREATE TABLE Student (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    gender BIT,
    cid INT,
    FOREIGN KEY (cid) REFERENCES Class(id)
);

CREATE TABLE Result (
    sid INT,
    subject VARCHAR(20),
    score DECIMAL(4,2),
    PRIMARY KEY (sid, subject),
    FOREIGN KEY (sid) REFERENCES Student(id)
);

INSERT INTO Class VALUES
(1,'12A','GV1'),
(2,'12B','GV2'),
(3,'12C','GV3');

INSERT INTO Student VALUES
(1,'LVT 1',b'0',2),
(2,'LVT 2',b'1',1),
(3,'LVT 3',b'0',2),
(4,'LVT 4',b'1',1),
(5,'LVT 5',b'0',3),
(6,'LVT 6',b'1',3);

INSERT INTO Result VALUES
(1,'Math',8),(1,'Literature',8),(1,'History',9.2),
(2,'Math',7.7),(2,'Literature',8),(2,'History',8.5),
(3,'Math',9.5),(3,'Literature',8.5),(3,'History',9),
(4,'Math',6.8),(4,'Literature',4.9),(4,'History',8.2),
(5,'Math',7.2),(5,'Literature',7.5),(5,'History',7.8),
(6,'Math',8.6),(6,'Literature',8.3),(6,'History',8.5);

-- DATABASE CAU 1
-- Primary key Result: (sid, subject)

-- DATABASE CAU 2
SELECT s.name,
       CAST(s.gender AS UNSIGNED) AS gender,
       c.teacher
FROM Student s
JOIN Class c ON s.cid = c.id;

-- DATABASE CAU 3
SELECT c.teacher, COUNT(s.id) AS total
FROM Class c
LEFT JOIN Student s ON s.cid = c.id
WHERE c.name = '12C'
GROUP BY c.id, c.teacher;

-- DATABASE CAU 4
SELECT c.name, COUNT(s.id) AS total
FROM Class c
JOIN Student s ON s.cid = c.id
JOIN Result m ON m.sid = s.id
    AND m.subject = 'Math' AND m.score >= 8
JOIN Result l ON l.sid = s.id
    AND l.subject = 'Literature' AND l.score >= 8
GROUP BY c.id, c.name;