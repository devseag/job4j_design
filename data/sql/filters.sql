create table type(
id serial primary key,
name text
);
create table product(
id serial primary key,
name text,
type_id int references type(id),
expired_date date,
price float
);
insert into type(name) values('cheese');
insert into type(name) values('sausage');
insert into type(name) values('milk');
insert into type(name) values('avocado');
insert into type(name) values('bread');
insert into type(name) values('candies');
insert into type(name) values('eggs');
insert into type(name) values('oats');
insert into type(name) values('soup');
insert into type(name) values('tomatos');
insert into type(name) values('cucumbers');
insert into product(name,type_id,expired_date,price) values('goat cheese',1,'2022-03-13',50.1);
insert into product(name,type_id,expired_date,price) values('sheep cheese',1,'2022-05-12',350.7);
insert into product(name,type_id,expired_date,price) values('creamy cheese',1,'2022-06-18',250.5);
insert into product(name,type_id,expired_date,price) values('cottage cheese',1,'2022-07-13',10.9);
insert into product(name,type_id,expired_date,price) values('parmezan',1,'2022-08-13',150.7);
insert into product(name,type_id,expired_date,price) values('berlin sausage',2,'2022-12-13',120.7);
insert into product(name,type_id,expired_date,price) values('chicken sausage',2,'2022-02-10',220.3);
insert into product(name,type_id,expired_date,price) values('goat milk',3,'2022-06-10',20.3);
insert into product(name,type_id,expired_date,price) values('cow milk',3,'2022-09-10',11.6);
insert into product(name,type_id,expired_date,price) values('ice cream',3,'2022-09-10',4.6);
insert into product(name,type_id,expired_date,price) values('mexican avocado',4,'2022-09-10',3.6);
insert into product(name,type_id,expired_date,price) values('american avocado',4,'2022-07-10',5.6);
insert into product(name,type_id,expired_date,price) values('whole wheet bread',5,'2022-04-10',8.6);
insert into product(name,type_id,expired_date,price) values('multigrain bread',5,'2022-04-23',9.6);
insert into product(name,type_id,expired_date,price) values('mix candies',6,'2022-06-23',2.4);
insert into product(name,type_id,expired_date,price) values('milk candies',6,'2022-06-23',2.9);
insert into product(name,type_id,expired_date,price) values('white eggs',7,'2022-04-23',5.9);
insert into product(name,type_id,expired_date,price) values('jumbo eggs',7,'2022-04-10',6.7);
insert into product(name,type_id,expired_date,price) values('omega 3 eggs',7,'2022-02-10',7.9);
insert into product(name,type_id,expired_date,price) values('oat meal',8,'2022-05-10',12.3);
insert into product(name,type_id,expired_date,price) values('chiken broth',9,'2022-08-10',1.9);
insert into product(name,type_id,expired_date,price) values('bean soup',9,'2022-08-15',2.2);
insert into product(name,type_id,expired_date,price) values('yellow tomatos',10,'2022-08-15',2.2);
insert into product(name,type_id,expired_date,price) values('ground tomatos',10,'2022-08-20',5.2);
insert into product(name,type_id,expired_date,price) values('red tomatos',10,'2022-08-25',8.2);
insert into product(name,type_id,expired_date,price) values('mini cucumbers',11,'2022-03-25',4.2);
insert into product(name,type_id,expired_date,price) values('pickles',11,'2022-03-25',3.3);

select p.name from product as p
join type as t
on p.type_id = t.id
where t.name ='cheese';

select name from product
where name like '%ice cream%';

select name from product
where expired_date< current_date;

select name,price from product
where price=(select max(price) from product);

select t.name, count(type_id) as count from product as p
join type as t
on t.id = p.type_id
group by t.name;

select p.name from product as p
join type as t
on p.type_id = t.id
where t.name ='cheese' or t.name ='milk';

select t.name, count(p.type_id) as count from product as p
join type as t
on t.id = p.type_id
group by t.name
having count(p.type_id)<10;

select p.name as product, t.name as type from product as p
join type as t on p.type_id=t.id;