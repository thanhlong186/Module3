use furama_resort;

CREATE TEMPORARY TABLE bang_tam2
SELECT dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem  FROM dich_vu_di_kem
JOIN hop_dong_chi_tiet
ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
JOIN hop_dong
ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
WHERE hop_dong_chi_tiet.so_luong > 10 
AND 
year(hop_dong.ngay_lam_hop_dong) = 2020;

SELECT * FROM bang_tam2;

UPDATE dich_vu_di_kem
SET dich_vu_di_kem.gia = dich_vu_di_kem.gia*2
WHERE dich_vu_di_kem.ma_dich_vu_di_kem IN (SELECT bang_tam2.ma_dich_vu_di_kem FROM bang_tam2);
DROP TABLE bang_tam2;