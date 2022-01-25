use furama_resort;

SELECT 
    hop_dong.ma_hop_dong,
    nhan_vien.ho_ten,
    khach_hang.ho_ten,
    khach_hang.so_dt,
    dich_vu.ten_dich_vu,
    dich_vu.ma_dich_vu,
    SUM(IFNULL(so_luong, 0)) AS so_luong_dich_vu_di_kem,
    hop_dong.tien_dat_coc
FROM
    khach_hang
        JOIN
    hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
        JOIN
    nhan_vien ON hop_dong.ma_nhan_vien = nhan_vien.ma_nv
        JOIN
    dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
        LEFT JOIN
    dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
WHERE
    (dich_vu.ten_dich_vu IN (SELECT 
            dich_vu.ten_dich_vu
        FROM
            dich_vu
                INNER JOIN
            hop_dong ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
        WHERE
            ((MONTH(hop_dong.ngay_lam_hop_dong) IN (10 , 11, 12))
                AND YEAR(hop_dong.ngay_lam_hop_dong) = 2020)))
        AND (dich_vu.ten_dich_vu NOT IN (SELECT 
            dich_vu.ten_dich_vu
        FROM
            dich_vu
                INNER JOIN
            hop_dong ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
        WHERE
            ((MONTH(hop_dong.ngay_lam_hop_dong) IN (1 , 2, 3, 4, 5, 6))
                AND YEAR(hop_dong.ngay_lam_hop_dong) = 2021)))
GROUP BY hop_dong.ma_hop_dong;
