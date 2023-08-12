create table Medicine_Card(
	id serial primary key,
	num int
);

create table Person(
	id serial primary key,
	name varchar(255),
	medicine_card_id int references Medicine_Card(id) unique
);

insert into Medicine_Card(num) values(123456789);
insert into Medicine_Card(num) values(123456799);
insert into Person(name,medicine_card_id) values('Tom',1);
insert into Person(name,medicine_card_id) values('Sam',2);