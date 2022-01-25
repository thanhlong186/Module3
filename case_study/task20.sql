use furama_resort;

SELECT ma_nv AS'#ID' ,ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi , "1" AS `TABLE`
FROM nhan_vien
union all
select ma_khach_hang AS'#ID',ho_ten, email, so_dt, ngay_sinh, dia_chi, "2" AS `TABLE`
from khach_hang;