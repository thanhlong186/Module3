use furama_resort;

SELECT khach_hang.ma_khach_hang,khach_hang.ho_ten,loai_khach.ten_loai_khach,
hop_dong.ma_hop_dong,dich_vu.ten_dich_vu,ngay_lam_hop_dong,ngay_ket_thuc,
if (hop_dong_chi_tiet.so_luong is null, dich_vu.chi_phi_thue, 
sum(dich_vu.chi_phi_thue + (hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia))) AS "số tiền"
 FROM khach_hang
LEFT JOIN loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
LEFT JOIN hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
LEFT JOIN dich_vu ON hop_dong.ma_dich_vu =  dich_vu.ma_dich_vu
LEFT JOIN hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
LEFT JOIN dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
GROUP BY hop_dong.ma_hop_dong
ORDER BY  khach_hang.ma_khach_hang , hop_dong.ma_hop_dong DESC ;