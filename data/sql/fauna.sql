create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);
insert into fauna (name, avg_age,discovery_date) values ('fish',34565,'1989-12-06');
insert into fauna (name, avg_age,discovery_date) values ('cat',677,'1789-07-02');
insert into fauna (name, avg_age,discovery_date) values ('dog',223450,'1969-10-10');
insert into fauna (name, avg_age,discovery_date) values ('mouse',1344,'1287-07-06');
insert into fauna (name, avg_age,discovery_date) values ('bird',823,'1216-05-01');
insert into fauna (name, avg_age,discovery_date) values ('fly',25,'1189-04-09');
insert into fauna (name, avg_age,discovery_date) values ('rat',234,'989-01-06');
insert into fauna (name, avg_age,discovery_date) values ('lizard',95670,'1689-07-06');
insert into fauna (name, avg_age,discovery_date) values ('butterfly',234,'1782-01-03');
insert into fauna (name, avg_age,discovery_date) values ('wolf',51234,'1886-03-12');
insert into fauna (name, avg_age,discovery_date) values ('bear',5237,'1345-12-01');
insert into fauna (name, avg_age,discovery_date) values ('fox',6347,'1432-09-12');
insert into fauna (name, avg_age,discovery_date) values ('racoon',21231,null );
insert into fauna (name, avg_age,discovery_date) values ('ferret',73456,'1123-08-03');
insert into fauna (name, avg_age,discovery_date) values ('chicken',1236,'1121-05-15');
insert into fauna(name, avg_age, discovery_date) values ('catfish', 231424, '1900-12-21');
insert into fauna(name, avg_age, discovery_date) values ('frog', 6456, '1950-12-21');
insert into fauna(name, avg_age, discovery_date) values ('horsefish', 56455, '2000-12-21');
insert into fauna(name, avg_age, discovery_date) values ('lion', 90424, '1950-01-01');
insert into fauna(name, avg_age, discovery_date) values ('turtle', 9999999, '1900-03-16');
insert into fauna(name, avg_age, discovery_date) values ('monkey', 20000, null);
insert into fauna(name, avg_age, discovery_date) values ('neanderthal', 89878, '2021-03-16');
select * from fauna where name like '%fish%';
select * from fauna where avg_age >= 10000 and avg_age <= 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '01.01.1950';