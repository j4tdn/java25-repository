create database lesson17_danghuy;

create table Class (
	id int primary key,
    name varchar(50) not null,
    teacher varchar(50) not null
);

create table Student (
	id int primary key,
    name varchar(100) not null,
    gender bit not null,
    cid int not null,
    foreign key (cid) references Class(id)
);

create table Result (
	sid int not null,
    subject varchar(50) not null,
    score decimal(4,2),
    primary key (sid, subject),
    foreign key (sid) references Student(id)
);

insert into Class (id, name, teacher) values
(1, "12A", "GV1"),
(2, "12B", "GV2"),
(3, "12C", "GV3");

insert into Student (id, name, gender, cid) values
(1, "LT1", 0, 2),
(2, "LT2", 1, 1),
(3, "LT3", 0, 2),
(4, "LT4", 1, 1),
(5, "LT5", 0, 2),
(6, "LT6", 1, 1);

insert into Result (sid, subject, score) values
(1, "Math", 8),
(1, "Literature", 7),
(1, "History", 9.5),
(2, "Math", 6.8),
(2, "Literature", 4.9),
(2, "History", 8.2),
(3, "Math", 9.8),
(3, "Literature", 7.2),
(3, "History", 8.8),
(4, "Math", 8),
(4, "Literature", 7),
(4, "History", 9.5),
(5, "Math", 6.8),
(5, "Literature", 4.9),
(5, "History", 8.2),
(6, "Math", 9.8),
(6, "Literature", 7.2),
(6, "History", 8.8)
