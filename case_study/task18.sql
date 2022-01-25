use furama_resort;

SET FOREIGN_KEY_CHECKS=0;
DELETE 
FROM khach_hang
WHERE ma_khach_hang IN (SELECT ma_khach_hang 
FROM hop_dong
WHERE 
year(ngay_lam_hop_dong) < 2021);
SET FOREIGN_KEY_CHECKS=1;

SELECT khach_hang.ma_khach_hang,
khach_hang.ho_ten
FROM khach_hang;