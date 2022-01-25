use furama_resort;

select * from khach_hang
where (select round(datediff(curdate(), ngay_sinh)/ 365,0))
between 18 and 50
and (dia_chi like "% Đà Nẵng" or dia_chi like "%Quảng Trị");
