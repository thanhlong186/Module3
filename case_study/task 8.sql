use furama_resort;

-- cách 1:
select khach_hang.ho_ten from khach_hang 
union 
select khach_hang.ho_ten from khach_hang;

-- cách 2:
select DISTINCT khach_hang.ho_ten from khach_hang;

-- cách 3:
SELECT
     ho_ten
FROM
    khach_hang
GROUP BY ho_ten;
