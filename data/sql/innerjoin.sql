create table passport(
    id serial primary key,
    seria int,
    number int
);

create table people(
    id serial primary key,
    name varchar(255),
    passport_id int references passport(id) unique
);

insert into passport(seria, number) values (1111, 123456);

insert into passport(seria, number) values (1112, 123457);
insert into passport(seria, number) values (1113, 123458);

insert into people(name, passport_id) values ('Ivan', 1);
insert into people(name, passport_id) values ('Boris', 2);
insert into people(name, passport_id) values ('Petr', 3);
insert into people(name) values ('Vasya');
insert into people(name) values ('Anya');

select * from people inner
join passport on people.passport_id = passport.id;

select * from people
join passport on people.passport_id = passport.id;

create table position(
    id serial primary key,
    name varchar(255)
);

create table employees(
    id serial primary key,
    name varchar(255),
    position_id int references position(id)
);

--UPDATED 0
--UPDATED 0
--UPDATED 1
--UPDATED 1
--UPDATED 1
--UPDATED 1
--UPDATED 1
--UPDATED 1
--UPDATED 1
--UPDATED 1
--
--id             | name           | passport_id    | id             | seria          | number
--1              | Ivan           | 1              | 1              | 1111           | 123456
--2              | Boris          | 2              | 2              | 1112           | 123457
--3              | Petr           | 3              | 3              | 1113           | 123458
--
--
--id             | name           | passport_id    | id             | seria          | number
--1              | Ivan           | 1              | 1              | 1111           | 123456
--2              | Boris          | 2              | 2              | 1112           | 123457
--3              | Petr           | 3              | 3              | 1113           | 123458

insert into position(name) values ('programmer');
insert into position(name) values ('project manager');
insert into position(name) values ('director');

insert into employees(name, position_id) values('Boris', 1);
insert into employees(name, position_id) values('Ivan', 1);
insert into employees(name, position_id) values('Kiril', 1);
insert into employees(name, position_id) values ('Marina', 2);
insert into employees(name, position_id) values ('Pers', 3);

insert into employees(name) values ('Alexander');

select * from employees
join position on employees.position_id = position.id;

--UPDATED 0
--UPDATED 0
--UPDATED 1
--UPDATED 1
--UPDATED 1
--UPDATED 1
--UPDATED 1
--UPDATED 1
--UPDATED 1
--UPDATED 1
--UPDATED 1
--
--id             | name           | position_id    | id             | name
--1              | Boris          | 1              | 1              | programmer
--2              | Ivan           | 1              | 1              | programmer
--3              | Kiril          | 1              | 1              | programmer
--4              | Marina         | 2              | 2              | project manager
--5              | Pers           | 3              | 3              | director

select pp.name, p.seria, p.number
from people as pp join passport as p on pp.passport_id = p.id;

select pp.name as Имя, p.seria as Серия, p.number as Номер
from people as pp join passport as p on pp.passport_id = p.id;

select pp.name as "Имя владельца", p.seria Серия, p.number Номер
from people pp join passport p on pp.passport_id = p.id;

--UPDATED 0
--UPDATED 0
--UPDATED 1
--UPDATED 1
--UPDATED 1
--UPDATED 1
--UPDATED 1
--UPDATED 1
--UPDATED 1
--UPDATED 1
--
--name           | seria          | number
--Ivan           | 1111           | 123456
--Boris          | 1112           | 123457
--Petr           | 1113           | 123458
--
--
--Имя            | Серия          | Номер
--Ivan           | 1111           | 123456
--Boris          | 1112           | 123457
--Petr           | 1113           | 123458
--
--
--Имя владельца  | Серия          | Номер
--Ivan           | 1111           | 123456
--Boris          | 1112           | 123457
--Petr           | 1113           | 123458

create table card(
id serial primary key,
num int,
date date
);
create table usersall(
id serial primary key,
name text,
card_id int references card(id)
);
insert into card (num,date) values(123,'1995-08-08');
insert into card (num,date) values(443,'2013-09-01');
insert into card (num,date) values(000,'2000-08-08');
insert into card (num,date) values(367,'2021-08-08');
insert into usersall (name,card_id) values('Sam',1);
insert into usersall (name,card_id) values('William',2);
insert into usersall (name,card_id) values('Jack',4);
insert into usersall (name,card_id) values('Ben',3);
insert into usersall (name) values('Tom');
insert into usersall (name) values('Jon');
select u.num, u.date, uu.name, uu.id from card as u join usersall as uu on u.id = uu.card_id;
select * from card as u join usersall as uu on u.id = uu.card_id;
select u.num, uu.name from card as u join usersall as uu on u.id = uu.card_id where u.id > 2;