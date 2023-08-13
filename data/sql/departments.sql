create table departments(
id serial primary key,
name text
);
create table employees(
id serial primary key,
name text,
departments_id int references departments(id)
);
insert into departments(name) values ('first');
insert into departments(name) values ('second');
insert into departments(name) values ('third');
insert into departments(name) values ('fourth');
insert into departments(name) values ('fifth');
insert into departments(name) values ('sixth');
insert into departments(name) values ('seventh');
insert into departments(name) values ('eighth');
insert into departments(name) values ('ninth');
insert into departments(name) values ('tenth');
insert into departments(name) values ('nothing');
insert into departments(name) values ('empty');
insert into employees(name,departments_id) values('Sam',1);
insert into employees(name,departments_id) values('Bill',1);
insert into employees(name,departments_id) values('Matt',1);
insert into employees(name,departments_id) values('Tom',1);
insert into employees(name,departments_id) values('Genny',2);
insert into employees(name,departments_id) values('Gery',2);
insert into employees(name,departments_id) values('Richard',2);
insert into employees(name,departments_id) values('Melany',2);
insert into employees(name,departments_id) values('Olga',2);
insert into employees(name,departments_id) values('Graig',2);
insert into employees(name,departments_id) values('Dean',3);
insert into employees(name,departments_id) values('Willaim',3);
insert into employees(name,departments_id) values('Simone',3);
insert into employees(name,departments_id) values('Krystal',3);
insert into employees(name,departments_id) values('Lee',3);
insert into employees(name,departments_id) values('Lee',4);
insert into employees(name,departments_id) values('Lidsay',4);
insert into employees(name,departments_id) values('Segey',4);
insert into employees(name,departments_id) values('Alexa',5);
insert into employees(name,departments_id) values('Candise',6);
insert into employees(name,departments_id) values('Liam',6);
insert into employees(name,departments_id) values('Brithany',6);
insert into employees(name,departments_id) values('Margary',7);
insert into employees(name,departments_id) values('Olympia',7);
insert into employees(name,departments_id) values('Helen',8);
insert into employees(name,departments_id) values('Margo',8);
insert into employees(name,departments_id) values('Melissa',8);
insert into employees(name,departments_id) values('Melissa',9);
insert into employees(name,departments_id) values('Zira',9);
insert into employees(name,departments_id) values('Amelia',9);
insert into employees(name,departments_id) values('Robert',10);
insert into employees(name,departments_id) values('Kerk',10);
insert into employees(name,departments_id) values('Karim',10);
insert into employees(name,departments_id) values('Vitaly',10);
insert into employees(name,departments_id) values('Rahim',null);
insert into employees(name,departments_id) values('Jack',null);
insert into employees(name,departments_id) values(null,1);
insert into employees(name,departments_id) values(null,2);
insert into employees(name,departments_id) values(null,7);
insert into employees(name,departments_id) values(null,9);
insert into employees(departments_id) values(9);
insert into employees(departments_id) values(1);
insert into employees(departments_id) values(2);
insert into employees(departments_id) values(3);


/*2. Vypolnit' zaprosy s left, rigth, full, cross soedinenijami*/
select * from departments d left join employees e on e.departments_id = d.id;
select * from departments d right join employees e on e.departments_id = d.id;
select * from employees cross join departments;


/*3. Ispol'zuja left join najti departamenty, u kotoryh net rabotnikov*/
select * from departments d left join employees e
on d.id = e.departments_id
where e.departments_id is null;

/*4. Ispol'zuja left i right join napisat' zaprosy, kotorye davali by odinakovyj rezul'tat.*/
select * from employees e left join departments d on e.departments_id = d.id
where e.name is not null and d.name is not null;

select * from employees e right join departments d on e.departments_id = d.id
where e.name is not null;