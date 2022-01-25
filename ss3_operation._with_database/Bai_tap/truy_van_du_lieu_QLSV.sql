use quan_ly_sinh_vien_new;

-- hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’:
select student.* from student where student.StudentName like "h%";

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12:
select class.* from class where class.StartDate like "____-12%";

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5:
select * from `subject` sub where sub.Credit between 3 and 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2:
SET SQL_SAFE_UPDATES = 0;	
update Student 
set ClassID = 2 
where StudentName = "Hung";
SET SQL_SAFE_UPDATES = 1;

select * from Student
where ClassID = 2;

-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
select student.StudentName, sub.SubName, ma.Mark
from Student student join Mark ma on student.StudentId = ma.StudentId
join `subject` sub on ma.SubId = sub.SubId
order by ma.Mark desc, ma.MarkId
