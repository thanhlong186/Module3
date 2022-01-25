use furama_resort;
select * from nhan_vien;

select nhan_vien.*
from nhan_vien
where (ho_ten like "h%"
or ho_ten like "t%"
or ho_ten like "k%") and char_length(ho_ten) < 15;


