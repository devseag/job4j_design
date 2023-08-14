start transaction; -- OR begin transaction;
set transaction isolation level repeatable read;
set session characteristics as transaction isolation level serializable;
start transaction isolation level read committed;
set transaction snapshot id_snapshot;
commit; -- OR commit transaction;
rollback; -- OR rollback transaction;
savepoint name_save_point;
release savepoint name_save_point;
rollback to savepoint name_save_point;

drop table products;
create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);
insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 15, 32);
insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 8, 115);

begin transaction;
insert into products (name, producer, count, price) VALUES ('product_4', 'producer_4', 11, 64);
commit transaction;
select * from products;
--"id"	"name"	"producer"	"count"	"price"
--1	"product_1"	"producer_1"	3	50
--2	"product_2"	"producer_2"	15	32
--3	"product_3"	"producer_3"	8	115
--4	"product_4"	"producer_4"	11	64

begin transaction;
delete from products;
--DELETE 4
drop table products;
rollback transaction;
select * from products;
--"id"	"name"	"producer"	"count"	"price"
--1	"product_1"	"producer_1"	3	50
--2	"product_2"	"producer_2"	15	32
--3	"product_3"	"producer_3"	8	115
--4	"product_4"	"producer_4"	11	64

begin transaction;
insert into products (name, producer, count, price) VALUES ('product_5', 'producer_5', 17, 45);
savepoint first_savepoint;
delete from products where price = 115;
update products set price = 75 where name = 'product_1';
select * from products;
--"id"	"name"	"producer"	"count"	"price"
--2	"product_2"	"producer_2"	15	32
--4	"product_4"	"producer_4"	11	64
--5	"product_5"	"producer_5"	17	45
--1	"product_1"	"producer_1"	3	75
rollback to first_savepoint;
--"id"	"name"	"producer"	"count"	"price"
--1	"product_1"	"producer_1"	3	50
--2	"product_2"	"producer_2"	15	32
--3	"product_3"	"producer_3"	8	115
--4	"product_4"	"producer_4"	11	64
--5	"product_5"	"producer_5"	17	45
commit transaction;
