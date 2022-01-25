use furama_resort;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, 
-- ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được 
-- tối đa 3 hợp đồng từ năm 2020 đến 2021.
SELECT 
    nhan_vien.ma_nv,
    nhan_vien.ho_ten,
    trinh_do.ten_trinh_do,
    bo_phan.ten_bo_phan,
    nhan_vien.so_dien_thoai,
    nhan_vien.dia_chi
FROM
    nhan_vien
        JOIN
    trinh_do ON trinh_do.ma_trinh_do = nhan_vien.ma_trinh_do
        JOIN
    bo_phan ON bo_phan.ma_bo_phan = nhan_vien.ma_bo_phan
        JOIN
    hop_dong ON hop_dong.ma_nhan_vien = nhan_vien.ma_nv
 WHERE 
       YEAR(hop_dong.ngay_lam_hop_dong) between 2020 and 2021
       GROUP BY hop_dong.ma_nhan_vien
       HAVING count(hop_dong.ma_nhan_vien) <= 3
       ORDER BY ma_nhan_vien;
       
    
