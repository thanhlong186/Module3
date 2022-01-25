use student_management;

create table `student_management`.`student` (
`id` int not null,
`name` varchar(45) null,
`age` int not null,
`country` varchar(45) null,
primary key(`id`));