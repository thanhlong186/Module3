use furama_resort;

SELECT 
    nhan_vien.ma_nv,
    nhan_vien.ho_ten
FROM
    nhan_vien;
SET SQL_SAFE_UPDATES = 0;

DELETE FROM nhan_vien 
WHERE
    nhan_vien.ma_nv NOT IN (SELECT DISTINCT
        ma_nhan_vien
    FROM
        hop_dong
    
    WHERE
        YEAR(hop_dong.ngay_lam_hop_dong) BETWEEN 2019 AND 2021);

SET SQL_SAFE_UPDATES = 1;