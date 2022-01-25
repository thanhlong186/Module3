use quan_ly_sinh_vien_new;
	
-- hiển thi tất cả các thông tin trong bảng subject có credit lớn nhất:    
select *
from `subject` sub 
where sub.Credit >= all (select max(Credit) from `subject`);

-- hiển thị các thông tin môn học có điểm thi lớn nhất:
select `subject`.*, Mark.Mark from `subject`
inner join Mark on `subject`.SubId = Mark.SubId order by Mark desc limit 1;

-- hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần:
-- cách 1:
select student.StudentName, avg(m.Mark) as "điểm trung binh"
from Student student 
join Mark m on 	student.StudentId = m.StudentId
group by student.StudentName
order by avg(m.Mark) desc limit 3;

-- cách 2:
SELECT student.* , AVG(m.Mark) FROM Student student 
INNER JOIN Mark m ON student.StudentId = m.StudentId
GROUP BY StudentId ORDER BY AVG(m.Mark) DESC LIMIT 3;