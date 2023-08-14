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

--"id"	"name"	"producer"	"count"	"price"
--1	"product_1"	"producer_1"	3	50
--2	"product_2"	"producer_2"	15	32
--3	"product_3"	"producer_3"	8	115

insert into products (name, count, price) VALUES ('product_4', 11, 64);
delete from products where price = 115;
update products set price = 75 where name = 'product_1';

commit;

begin transaction isolation level repeatable read;

begin transaction isolation level serializable read;


--	                                Poterjannoe obnovlenie	Grjaznoe chtenie	Nepovtorjajushheesja chtenie	Fantomnoe chtenie
--Chtenie nepodtverzhdennyh dannyh	Zashhishhaet        --	Ne zashhishhaet     --	Ne zashhishhaet         --	Ne zashhishhaet
--Chtenie podtverzhdennyh dannyh	Zashhishhaet        --	Zashhishhaet        --	Ne zashhishhaet         --	Ne zashhishhaet
--Povtorjajushheesja chtenie	    Zashhishhaet        --	Zashhishhaet        --	Zashhishhaet            --	V PG  zashhishhaet
--Snimok	                        Zashhishhaet        --	Zashhishhaet        --	Zashhishhaet            --	Ne zashhishhaet
--Serializacija	                    Zashhishhaet        --	Zashhishhaet        --	Zashhishhaet            --	Zashhishhaet

