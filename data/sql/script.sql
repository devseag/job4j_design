create table employee(
	id serial primary key,
	age int,
	married bool,
	birthday date

);
insert into employee (age,married,birthday) values (32,true,'1989-07-06');
update employee set age = 30;
delete from employee;