drop database furama_resort;
create database furama_resort;

use furama_resort;

create table vi_tri(
ma_vi_tri int primary key,
ten_vi_tri varchar(45)
);
SET FOREIGN_KEY_CHECKS = 0;
alter table vi_tri 
modify ma_vi_tri int auto_increment;
SET FOREIGN_KEY_CHECKS = 1;

create table trinh_do(
ma_trinh_do int primary key,
ten_trinh_do varchar(45)
);
SET FOREIGN_KEY_CHECKS = 0;
alter table trinh_do 
modify ma_trinh_do int auto_increment;
SET FOREIGN_KEY_CHECKS = 1;


create table bo_phan(
ma_bo_phan int primary key,
ten_bo_phan varchar(45)
);
SET FOREIGN_KEY_CHECKS = 0;
alter table bo_phan 
modify ma_bo_phan int auto_increment;
SET FOREIGN_KEY_CHECKS = 1;


create table furama_resort.nhan_vien(
ma_nv int primary key,
ho_ten varchar(45) not null,
ngay_sinh date not null,
so_cmnd varchar(45) not null,
luong double not null,
so_dien_thoai varchar(45) not null,
email varchar(45),
dia_chi varchar(45),
ma_vi_tri int,
ma_trinh_do int,
ma_bo_phan int,
foreign key(ma_vi_tri) references vi_tri(ma_vi_tri),
foreign key(ma_trinh_do) references trinh_do(ma_trinh_do),
foreign key(ma_bo_phan) references bo_phan(ma_bo_phan)
);
SET FOREIGN_KEY_CHECKS = 0;
alter table nhan_vien 
modify ma_nv int auto_increment;
SET FOREIGN_KEY_CHECKS = 1;

create table loai_khach(
ma_loai_khach int primary key,
ten_loai_khach varchar(45)
);
SET FOREIGN_KEY_CHECKS = 0;
alter table loai_khach 
modify ma_loai_khach int auto_increment;
SET FOREIGN_KEY_CHECKS = 1;


create table khach_hang(
ma_khach_hang int primary key,
ma_loai_khach int,
ho_ten varchar(45) not null,
ngay_sinh date not null,
gioi_tinh bit(1) not null,
so_cmnd varchar(45) not null,
so_dt varchar(45) not null,
email varchar(45),
dia_chi varchar(45),
foreign key(ma_loai_khach) references loai_khach(ma_loai_khach)
);
SET FOREIGN_KEY_CHECKS = 0;
alter table khach_hang 
modify ma_khach_hang int auto_increment;
SET FOREIGN_KEY_CHECKS = 1;



create table kieu_thue(
ma_kieu_thue int primary key,
ten_kieu_thue varchar(45)
);
SET FOREIGN_KEY_CHECKS = 0;
alter table kieu_thue 
modify ma_kieu_thue int auto_increment;
SET FOREIGN_KEY_CHECKS = 1;

create table loai_dich_vu(
ma_loai_dich_vu int primary key,
ten_loai_dich_vu varchar(45)
);
SET FOREIGN_KEY_CHECKS = 0;
alter table loai_dich_vu 
modify ma_loai_dich_vu int auto_increment;
SET FOREIGN_KEY_CHECKS = 1;

create table dich_vu(
ma_dich_vu int auto_increment primary key,
ten_dich_vu varchar(45) not null,
dien_tich int,
chi_phi_thue double not null,
so_nguoi_toi_da int,
ma_kieu_thue int,
ma_loai_dich_vu int,
tieu_chuan_phong varchar(45),
mo_ta_tien_nghi_khac varchar(45),
dien_tich_ho_boi double,
so_tang int,
foreign key(ma_kieu_thue) references kieu_thue(ma_kieu_thue),
foreign key(ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu)
);

create table hop_dong(
ma_hop_dong int auto_increment primary key,
ngay_lam_hop_dong datetime not null,
ngay_ket_thuc datetime not null,
tien_dat_coc double not null,
ma_nhan_vien int,
ma_khach_hang int,
ma_dich_vu int,
foreign key(ma_nhan_vien) references nhan_vien(ma_nv),
foreign key(ma_khach_hang) references khach_hang(ma_khach_hang),
foreign key(ma_dich_vu) references dich_vu(ma_dich_vu)
);


create table dich_vu_di_kem(
ma_dich_vu_di_kem int auto_increment primary key,
ten_dich_vu_di_kem varchar(45) not null,
gia double not null,
don_vi varchar(10) not null,
trang_thai varchar(45)
);

create table hop_dong_chi_tiet(
ma_hop_dong_chi_tiet int auto_increment primary key,
ma_hop_dong int,
ma_dich_vu_di_kem int,
so_luong int not null,
foreign key(ma_hop_dong) references hop_dong(ma_hop_dong),
foreign key(ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem)
);

