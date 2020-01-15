CREATE TABLE STUDENT (
    id NUMBER(10) NOT NULL,
    name VARCHAR2(50),
    age NUMBER(10),
    sex VARCHAR2(50)
);

CREATE TABLE SUBJECT (
    id NUMBER(10) NOT NULL,
    subject VARCHAR2(50),
    teacher VARCHAR2(50),
    description VARCHAR2(255)
);

CREATE TABLE SCORE (
    id NUMBER(10) NOT NULL,
    student_id NUMBER(10),
    subject_id NUMBER(10),
    score NUMBER(10)
);

INSERT INTO STUDENT (id, name, age, sex) VALUES (001,'zhangsan',18,'male');
INSERT INTO STUDENT (id, name, age, sex) VALUES (002,'lisi',20,'female');

INSERT INTO SUBJECT (id, subject, teacher, description) VALUES (1001,'Chinese','Mr. Wang','the exam is easy');
INSERT INTO SUBJECT (id, subject, teacher, description) VALUES (1002,'math','Miss Liu','the exam is difficult');

INSERT INTO SCORE (id, student_id, subject_id, score) VALUES (1,001,1001,80);
INSERT INTO SCORE (id, student_id, subject_id, score) VALUES (2,002,1002,60);
INSERT INTO SCORE (id, student_id, subject_id, score) VALUES (3,001,1001,70);
INSERT INTO SCORE (id, student_id, subject_id, score) VALUES (4,002,1002,60.5);

SELECT * FROM STUDENT;
SELECT * FROM SUBJECT;
SELECT * FROM SCORE;