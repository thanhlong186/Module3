use furama_resort;

select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
from dich_vu left join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
left join hop_dong ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
where  dich_vu.ten_dich_vu
not in(select dich_vu.ten_dich_vu
from dich_vu join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
where  hop_dong.ngay_lam_hop_dong
between "2021/01/01" and"2021/03/31")
group by ma_dich_vu order by chi_phi_thue desc;
