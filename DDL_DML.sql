--============================--
--1. DDL: Database Level
--============================--
--Display all the database
SHOW DATABASES;

--Enter a certain database
USE testing;

--Create a database
CREATE DATABASE testing;

--Create the database of the designated character set
CREATE DATABASE testing CHARACTER SET latin1 COLLATE test_name;

--Display the creation information for the database
SHOW CREATE DATABASE testing;
SHOW CREATE SCHEMA testing;

--Revise the codes of the database
ALTER DATABASE testing CHARACTER SET = 'utf8'  COLLATE = 'utf8_bin';

--Delete a database
DROP DATABASE testing;

--============================--
--1. DDL: Table Level
--============================--
--Revise table name
RENAME TABLE student TO NEW_student;

--Revise the field's data type
ALTER TABLE student MODIFY AGE VARCHAR;

--Revise field name
ALTER TABLE student RENAME COLUMN AGE TO DOB;

--Add field
ALTER TABLE student ADD telephone_num INT;

--Delete field
ALTER TABLE student DROP COLUMN SEX;

--Revise the table's storage engine
ALTER TABLE student ENGINE=InnoDB;

--Delete the table's foreign key restriant
ALTER TABLE student DROP FOREIGN KEY fk_example;

--Delete a table
DELETE FROM student;

--============================--
--2. DML
--============================--
-- Insert record
INSERT INTO student (id, name, age, sex) VALUES (001,'zhangsan',18,'male');

-- Revise record
UPDATE student SET NAME = 'new name' WHERE NAME = 'zhangsan';

-- Delete record
DELETE FROM student WHERE ID = 1;

-- Search record 
SELECT * FROM student WHERE AGE = 18;
