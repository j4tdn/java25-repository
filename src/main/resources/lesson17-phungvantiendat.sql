CREATE DATABASE lesson17_test;

use lesson17_test;

CREATE TABLE class(
    id bigint auto_increment primary key,
    name varchar(255),
    teacher varchar(55)
);

CREATE TABLE student(
    id bigint auto_increment primary key,
    name varchar(255),
    gender bit,
    cid bigint,
    foreign key(cid) references class(id)
);

CREATE table result(
    sid bigint ,
    subject varchar(35),
    score double,
    primary key(sid, subject),
    foreign key(sid) references student(id)
);

INSERT INTO class (id, name, teacher) VALUES
(1, '12A', 'GV1'),
(2, '12B', 'GV2'),
(3, '12C', 'GV3');

INSERT INTO student (id, name, gender, cid) VALUES
(1, 'LVT1', b'1', 2),
(2, 'LVT2', b'1', 1),
(3, 'LVT3', b'0', 2),
(4, 'LVT4', b'1', 1),
(5, 'LVT5', b'0', 3),
(6, 'LVT6', b'1', 3);


INSERT INTO result (sid, subject, score) VALUES
(1, 'Math', 8.0),
(2, 'Literature', 7.0),
(3, 'History', 9.5),
(4, 'Math', 6.8),
(5, 'Literature', 4.9),
(6, 'History', 8.2);

INSERT INTO student (id, name, gender, cid) VALUES
(7, 'LVT7', b'1', 2),
(8, 'LVT8', b'0', 3);

INSERT INTO result (sid, subject, score) VALUES
(7, 'Math', 9.0),
(7, 'Literature', 8.5),
(8, 'Math', 8.5),
(8, 'Literature', 9.0);

-- Answer 1 questions:
-- 1. What is primary key of Result table.

-- khóa chính của bảng result là composite key gồm (sid,subject)
-- tại vì nếu chỉ sid thì sẽ không đúng vì một học sinh học nhiều môn và có điểm số tương ứng với môn đó ở đây thì sid là không hợp lý
-- subject thì cũng có thể trùng nhau nên hợp lý nhất sẽ là khóa kết hợp

-- Write 3 queries to:
-- 2. List name, gender and teacher name of all students.
SELECT s.name, s.gender, c.teacher
FROM student s
JOIN class c
ON s.cid = c.id;

-- 3. List teacher name and number of all student in class 12C.
SELECT c.teacher, count(s.id)
FROM student s
JOIN class c
ON s.cid = c.id
WHERE c.name = '12C'
GROUP BY c.teacher;

-- 4. List the class name and number of the students who have good at Math (score>=8) and
-- good at Literature (score>=8).
WITH CTE_GOOD_MATH AS (
	SELECT sid
    FROM result 
    WHERE subject = 'Math' and score >= 8
),
CTE_GOOD_LIT AS (
	SELECT sid
	FROM result 
    WHERE subject = 'Literature' and score >= 8
)

SELECT c.name, COUNT(s.id)
FROM student s
JOIN class c
	ON s.cid = c.id
JOIN CTE_GOOD_MATH cgm
	ON cgm.sid = s.id
JOIN CTE_GOOD_LIT cgl
	ON cgl.sid = s.id
GROUP BY c.name, s.id