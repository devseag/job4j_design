create table owners(
    id serial primary key,
    name varchar(255)
);

create table devices(
    id serial primary key,
    name varchar(255),
    owner_id int references owners(id)
);

insert into owners(name) values ('Owner 1');
insert into owners(name) values ('Owner 2');
insert into owners(name) values ('Owner 3');

insert into devices(name, owner_id) values ('Device 1', 1);
insert into devices(name, owner_id) values ('Device 2', 2);
insert into devices(name, owner_id) values ('Device 3', 3);
insert into devices(name, owner_id) values ('Device 4', null);
insert into devices(name, owner_id) values ('Device 5', null);
insert into devices(name, owner_id) values ('Device 6', 1);

-- left outer join

select * from devices d left join owners o on d.owner_id = o.id;

--1	Device 1	1	1	Owner 1
--2	Device 2	2	2	Owner 2
--3	Device 3	3	3	Owner 3
--4	Device 4
--5	Device 5
--6	Device 6	1	1	Owner 1

select * from devices d left join owners o on d.owner_id = o.id where o.id is null;

--4	Device 4
--5	Device 5

select * from owners o left join devices d on o.id = d.owner_id;

--1	Owner 1	1	Device 1	1
--2	Owner 2	2	Device 2	2
--3	Owner 3	3	Device 3	3
--1	Owner 1	6	Device 6	1

-- right outer join

select * from devices d left join owners o on d.owner_id = o.id;

--1	Device 1	1	1	Owner 1
--2	Device 2	2	2	Owner 2
--3	Device 3	3	3	Owner 3
--4	Device 4
--5	Device 5
--6	Device 6	1	1	Owner 1

select * from owners o right join devices d on d.owner_id = o.id;

--1	Owner 1	1	Device 1	1
--2	Owner 2	2	Device 2	2
--3	Owner 3	3	Device 3	3
--		4	Device 4
--		5	Device 5
--1	Owner 1	6	Device 6	1

select * from owners o left join devices d on o.id = d.owner_id;

--1	Owner 1	1	Device 1	1
--2	Owner 2	2	Device 2	2
--3	Owner 3	3	Device 3	3
--1	Owner 1	6	Device 6	1

select * from devices d right join owners o on d.owner_id = o.id;

--1	Device 1	1	1	Owner 1
--2	Device 2	2	2	Owner 2
--3	Device 3	3	3	Owner 3
--6	Device 6	1	1	Owner 1

-- full join

select * from devices d full join owners o on d.owner_id = o.id;

--1	Device 1	1	1	Owner 1
--2	Device 2	2	2	Owner 2
--3	Device 3	3	3	Owner 3
--4	Device 4
--5	Device 5
--6	Device 6	1	1	Owner 1

select * from devices d left join owners o on d.owner_id = o.id
union
select * from devices d right join owners o on d.owner_id = o.id

-- cross join

select * from devices d cross join owners o;

--1	Device 1	1	1	Owner 1
--1	Device 1	1	2	Owner 2
--1	Device 1	1	3	Owner 3
--2	Device 2	2	1	Owner 1
--2	Device 2	2	2	Owner 2
--2	Device 2	2	3	Owner 3
--3	Device 3	3	1	Owner 1
--3	Device 3	3	2	Owner 2
--3	Device 3	3	3	Owner 3
--4	Device 4		1	Owner 1
--4	Device 4		2	Owner 2
--4	Device 4		3	Owner 3
--5	Device 5		1	Owner 1
--5	Device 5		2	Owner 2
--5	Device 5		3	Owner 3
--6	Device 6	1	1	Owner 1
--6	Device 6	1	2	Owner 2
--6	Device 6	1	3	Owner 3

create table numbers(
    num int unique
);

insert into numbers(num) values (1);
insert into numbers(num) values (2);
insert into numbers(num) values (3);

select n1.num as a, n2.num as b, (n1.num * n2.num) as "a*b=" from numbers n1 cross join numbers n2;

--UPDATED 0
--UPDATED 1
--UPDATED 1
--UPDATED 1
--
--a              | b              | a*b=
--1              | 1              | 1
--1              | 2              | 2
--1              | 3              | 3
--2              | 1              | 2
--2              | 2              | 4
--2              | 3              | 6
--3              | 1              | 3
--3              | 2              | 6
--3              | 3              | 9

