use furama_resort;

select hop_dong.ma_khach_hang,khach_hang.ho_ten,COUNT(ma_hop_dong) from hop_dong 
inner join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang 
inner join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
where ten_loai_khach like "Diamond" 
group by  hop_dong.ma_khach_hang
order by COUNT(ma_hop_dong) asc ;