# 1.Query the existence of 1 course
SELECT * FROM student_course GROUP BY studentid HAVING COUNT(studentid) = 1;

# 2.Query the presence of both 1 and 2 courses
SELECT * FROM student_course GROUP BY studentid HAVING COUNT(studentId) <= 2 AND COUNT(studentId) > 0;

# 3.Query the student number and student name and average score of students whose average score is 60 or higher.
SELECT DISTINCT s.id, s.name, c.score
FROM student s 
JOIN student_course c ON (s.id = c.studentId)
WHERE c.score >= 60
GROUP BY s.name;

# 4.Query the SQL statement of student information that does not have grades in the student_course table
SELECT * FROM student_course
WHERE score IS NULL;

# 5.Query all SQL with grades
SELECT * FROM student_course
WHERE score IS NOT NULL;

# 6.Inquire about the information of classmates who have numbered 1 and also studied the course numbered 2
SELECT * FROM student s
WHERE s.id = (
	SELECT studentId FROM student_course 
	WHERE studentId = 1 AND courseId = 2
);

# 7.Retrieve 1 student score with less than 60 scores in descending order
SELECT DISTINCT s.id, s.name, c.score
FROM student s 
JOIN student_course c ON (s.id = c.studentId)
WHERE c.score < 60
GROUP BY s.name DESC;

# 8.Query the average grade of each course. The results are ranked in descending order of average grade. When the average grades are the same, they are sorted in ascending order by course number.
SELECT c.name, AVG(s.score) 'Average_Score'
FROM course c
JOIN student_course s ON (c.id = s.courseId)
GROUP BY s.courseId
ORDER BY Average_Score DESC;

# 9.Query the name and score of a student whose course name is "Math" and whose score is less than 60
SELECT std.name, s.score FROM student_course s
JOIN course c ON (s.courseId = c.id)
JOIN student std ON (s.studentId = std.id)
WHERE c.name = 'Math' 
AND s.score < 60;