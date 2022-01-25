create database quan_ly_diem_thi;

use quan_ly_diem_thi;

create table hoc_sinh(
code_hs varchar(20) primary key,
ten_hs varchar(50),
day_of_bỉth datetime,
class_hs varchar(20),
gt_hs varchar(20)
);

create table mon_hoc(
code_mh varchar(20) primary key,
ten_mh varchar(50)
);

create table bang_diem(
code_hs varchar(20),
code_mh varchar(20),
diem_thi int,
ngay_kt datetime,
primary key (code_hs, code_mh),
foreign key (code_hs) references hoc_sinh(code_hs),
foreign key (code_mh) references mon_hoc(code_mh)
);

create table giao_vien(
code_gv varchar(20) primary key,
name_gv varchar(20),
phone varchar(10)
);
alter table mon_hoc add code_gv varchar(20);
alter table mon_hoc add constraint fk_ma_gv foreign key(code_gv) references giao_vien(code_gv);