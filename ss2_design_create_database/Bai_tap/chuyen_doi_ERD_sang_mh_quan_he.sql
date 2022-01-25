create database don_hang;

use don_hang;

create table phieu_xuat(
so_px int primary key,
ngay_xuat date
);

create table vat_tu(
ma_vt int primary key,
ten_vt varchar(60)
);

create table phieu_nhap(
so_pn int primary key,
ngay_nhap date
);

create table don_dat_hang(
so_dh int primary key,
ngay_dh date 
);

create table nha_cung_cap(
ma_ncc int primary key,
ten_ncc varchar(45),
dia_chi varchar(45),
so_dt varchar(45)
);

create table chi_tiet_px(
dg_xuat int,
sl_xuat int,
id_so_px int,
id_ma_vt int,
primary key (id_so_px, id_ma_vt),
foreign key (id_so_px) references phieu_xuat(so_px),
foreign key (id_ma_vt) references vat_tu(ma_vt)
);

create table chi_tiet_pn(
dg_nhap int,
sl_nhap int,
ma_vt int,
so_pn int,
primary key (ma_vt, so_pn),
foreign key (ma_vt) references vat_tu(ma_vt),
foreign key (so_pn) references phieu_nhap(so_pn)
);

create table chi_tiet_don_dat_hang(
ma_vt int,
so_don_hang int,
primary key (ma_vt,so_don_hang),
foreign key (ma_vt) references vat_tu(ma_vt),
foreign key (so_don_hang) references don_dat_hang(so_dh)
);

create table cung_cap(
so_don_hang int,
ma_ncc int ,
primary key(so_don_hang,ma_ncc),
foreign key (so_don_hang) references don_dat_hang(so_dh),
foreign key (ma_ncc) references nha_cung_cap(ma_ncc)
);