drop database casestudy_jsp;
create database casestudy_jsp;

use casestudy_jsp;

create table position (
position_id int primary key auto_increment,
position_name varchar(45) 
);

create table education_degree(
education_degree_id int primary key auto_increment,
education_degree_name varchar(45)
);

create table division (
division_id int primary key auto_increment,
division_name varchar(45)
);

create table `user` (
username varchar(255) primary key,
`password` varchar(255) 
);

create table employee (
employee_id int primary key auto_increment,
employee_name varchar(45) not null,
employee_birthday date not null,
employee_id_card varchar(45) not null,
employee_salary double not null,
employee_phone varchar(45) not null,
employee_email varchar(45),
employee_address varchar(45),
position_id int,
education_degree_id int,
division_id int,
username varchar(255),
foreign key (position_id) references position (position_id ) ON DELETE CASCADE ON UPDATE CASCADE,
foreign key (education_degree_id) references education_degree (education_degree_id) ON DELETE CASCADE ON UPDATE CASCADE,
foreign key (division_id) references division (division_id) ON DELETE CASCADE ON UPDATE CASCADE,
foreign key (username) references `user` (username) ON DELETE CASCADE ON UPDATE CASCADE
);

create table customer_type (
customer_type_id int primary key auto_increment,
customer_type_name varchar(45)
);

create table customer (
customer_id int primary key auto_increment,
customer_code varchar(45),
customer_type_id int,
customer_name varchar(45) not null,
customer_birthday date not null,
customer_gender bit(1) not null,
customer_id_card varchar(45) not null,
customer_phone varchar(45) not null,
customer_email varchar(45),
customer_address varchar(45),
foreign key (customer_type_id) references customer_type (customer_type_id) ON DELETE CASCADE ON UPDATE CASCADE
);

create table service_type (
service_type_id int primary key auto_increment,
service_type_name varchar(45)
);

create table rent_type (
rent_type_id int primary key auto_increment,
rent_type_name varchar(45),
rent_type_cost double
);

create table service (
service_id int primary key auto_increment,
service_code varchar(45),
service_name varchar(45) not null,
service_area int,
service_cost double not null,
service_max_people int,
rent_type_id int,
service_type_id int,
standard_room varchar(45),
description_other_convenience varchar(45),	
pool_area double,
number_of_floor int,
foreign key (rent_type_id) references rent_type (rent_type_id) ON DELETE CASCADE ON UPDATE CASCADE,
foreign key (service_type_id) references service_type (service_type_id) ON DELETE CASCADE ON UPDATE CASCADE

);

create table contract (
contract_id int primary key auto_increment,
contract_start_date datetime not null,
contract_end_date datetime not null,
contract_deposit double not null,
employee_id int,
customer_id int,
service_id int,
foreign key (employee_id) references employee (employee_id) ON DELETE CASCADE ON UPDATE CASCADE,
foreign key (customer_id) references customer (customer_id) ON DELETE CASCADE ON UPDATE CASCADE,
foreign key (service_id) references service (service_id) ON DELETE CASCADE ON UPDATE CASCADE

);

create table attach_service (
attach_service_id int primary key auto_increment,
attach_service_name varchar(45) not null,
attach_service_cost double not null,
attach_service_unit varchar(10) not null,
attach_service_status varchar(45)
);

create table contract_detail (
contract_detail_id int primary key auto_increment,
contract_id int,
attach_service_id int,
quatity int not null,
foreign key (contract_id) references contract (contract_id) ON DELETE CASCADE ON UPDATE CASCADE,
foreign key (attach_service_id) references attach_service (attach_service_id) ON DELETE CASCADE ON UPDATE CASCADE

);



create table `role` (
role_id int primary key auto_increment,
role_name varchar(255)
);

create table user_role (
role_id int,
username varchar(255),
foreign key (role_id) references `role` (role_id) ON DELETE CASCADE ON UPDATE CASCADE,
foreign key (username) references `user` (username) ON DELETE CASCADE ON UPDATE CASCADE
);



