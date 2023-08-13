create table students(
    id serial primary key, name text
);

create table subjects(
    id serial primary key, name text
);

create table students_subjects(
    id serial primary key, 
    mark float, 
    student_id int references students(id), 
    subject_id int references subjects(id)
);

insert into students(name) values ('Аня'), ('Ваня'), ('Боря');
insert into subjects(name) values ('Математика'), ('Русский'), ('Информатика');
insert into students_subjects(student_id, subject_id, mark) values (1, 1, 5), (1, 2, 5), (1, 3, 5);
insert into students_subjects(student_id, subject_id, mark) values (2, 1, 5), (2, 2, 4), (2, 3, 4);
insert into students_subjects(student_id, subject_id, mark) values (3, 1, 3), (3, 2, 5), (3, 3, 3);

select avg(mark) from students_subjects;
select min(mark) from students_subjects;
select max(mark) from students_subjects;

select s.name, avg(ss.mark) 
from students_subjects as ss 
join subjects s 
on ss.subject_id = s.id 
group by s.name;

select s.name, avg(ss.mark) 
from students_subjects as ss 
join students s 
on ss.student_id = s.id 
group by s.name;

select s.name, avg(ss.mark) 
from students_subjects as ss 
join subjects s 
on ss.subject_id = s.id 
group by s.name 
having avg(ss.mark) > 4.2;

--UPDATED 0
--UPDATED 0
--UPDATED 0
--UPDATED 3
--UPDATED 3
--UPDATED 3
--UPDATED 3
--UPDATED 3
--
--avg
--4.333333333333333
--
--
--min
--3.0
--
--
--max
--5.0
--
--
--name           | avg
--Математика     | 4.333333333333333
--Информатика    | 4.0
--Русский        | 4.666666666666667
--
--
--name           | avg
--Ваня           | 4.333333333333333
--Боря           | 3.6666666666666665
--Аня            | 5.0
--
--
--name           | avg
--Математика     | 4.333333333333333
--Русский        | 4.666666666666667

create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);
insert into devices(name,price) values ('iphone',2000.5);
insert into devices(name,price) values ('ipad',5040.5);
insert into devices(name,price) values ('phone',500.7);
insert into devices(name,price) values ('tablet',2000.56);
insert into devices(name,price) values ('tv_station',10300.7);
insert into devices(name,price) values ('earphones',700.9);
insert into people(name) values ('Jon');
insert into people(name) values ('Sam');
insert into people(name) values ('Dean');
insert into people(name) values ('Bill');
insert into people(name) values ('Tom');
insert into people(name) values ('Jack');
insert into people(name) values ('William');
insert into people(name) values ('Ben');
insert into devices_people(device_id,people_id) values(1,1);
insert into devices_people(device_id,people_id) values(1,2);
insert into devices_people(device_id,people_id) values(1,3);
insert into devices_people(device_id,people_id) values(1,4);
insert into devices_people(device_id,people_id) values(1,7);
insert into devices_people(device_id,people_id) values(1,8);
insert into devices_people(device_id,people_id) values(1,5);
insert into devices_people(device_id,people_id) values(1,6);
insert into devices_people(device_id,people_id) values(2,6);
insert into devices_people(device_id,people_id) values(2,2);
insert into devices_people(device_id,people_id) values(2,1);
insert into devices_people(device_id,people_id) values(2,8);
insert into devices_people(device_id,people_id) values(2,3);
insert into devices_people(device_id,people_id) values(null,7);
insert into devices_people(device_id,people_id) values(4,2);
insert into devices_people(device_id,people_id) values(4,5);
insert into devices_people(device_id,people_id) values(5,5);
insert into devices_people(device_id,people_id) values(5,8);
insert into devices_people(device_id,people_id) values(5,1);
insert into devices_people(device_id,people_id) values(5,3);
insert into devices_people(device_id,people_id) values(5,6);
insert into devices_people(device_id,people_id) values(6,1);
insert into devices_people(device_id,people_id) values(6,8);
insert into devices_people(device_id,people_id) values(6,3);
insert into devices_people(device_id,people_id) values(6,4);

select avg(price) from devices;

select p.name, avg(d.price) as avg_price from devices_people as dp
join people as p on p.id = dp.people_id
join devices as d on d.id = dp.device_id
group by p.name;

select p.name, avg(d.price) as avg_price from devices_people as dp
join people as p on p.id = dp.people_id
join devices as d on d.id = dp.device_id
group by p.name
having avg(d.price)>5000;