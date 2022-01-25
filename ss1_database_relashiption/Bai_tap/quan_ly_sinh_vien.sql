drop database if exists quan_ly_sinh_vien;

create database quan_ly_sinh_vien;

use quan_ly_sinh_vien;

create table class(
code_class int,
name_class varchar(70),
primary key(code_class)
);
insert into class values (1,"Long");
select * from class;

create table teacher(
code_teacher int,
name_teacher varchar(70),
age_teacher int,
country_teacher varchar(70),
primary key(code_teacher)
);
insert into teacher values(1,"Duong",23,"Quang Nam");
select * from teacher;