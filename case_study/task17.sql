use furama_resort;

-- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với 
-- Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
UPDATE khach_hang
SET ma_loai_khach = 1
WHERE ma_loai_khach!=1 AND ma_khach_hang IN (SELECT tmp.ma_khach_hang FROM(SELECT khach_hang.ma_khach_hang
FROM khach_hang 
JOIN hop_dong  ON hop_dong.ma_khach_hang=khach_hang.ma_khach_hang
JOIN dich_vu  ON dich_vu.ma_dich_vu=hop_dong.ma_dich_vu
JOIN hop_dong_chi_tiet ON hop_dong.ma_hop_dong=hop_dong_chi_tiet.ma_hop_dong
JOIN dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
GROUP BY khach_hang.ma_khach_hang
HAVING (SUM(ifnull(dich_vu.chi_phi_thue,0) + ifnull(dich_vu_di_kem.gia,0)* ifnull(hop_dong_chi_tiet.so_luong,0))>=10000000))AS tmp);

select khach_hang.ma_khach_hang ,
khach_hang.ho_ten,
khach_hang.ma_loai_khach = 1 AS loai_dich_vu
from khach_hang;
