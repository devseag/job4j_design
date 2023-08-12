create table customer(
	id serial primary key,
	name varchar(255)
);
create table orders(
    id serial primary key,
    order_number int,
    customer_id int references customer(id)
);
insert into customer (name) values('Tom');
insert into customer (name) values('Jon');
insert into customer (name) values('Sam');
insert into orders(order_number,customer_id) values(123,1);
insert into orders(order_number,customer_id) values(124,1);
insert into orders(order_number,customer_id) values(125,2);
insert into orders(order_number,customer_id) values(126,3);
insert into orders(order_number,customer_id) values(127,3);