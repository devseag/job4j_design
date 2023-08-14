create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create trigger discount_trigger
    after insert
    on products
    for each row
    execute procedure discount();

create or replace function discount()
    returns trigger as
$$
    BEGIN
        update products
        set price = price - price * 0.2
        where count <= 5 AND id = new.id;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 8, 115);
--1	"product_3"	"producer_3"	8	115
insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);
--1	"product_3"	"producer_3"	8	115
--2	"product_1"	"producer_1"	3	40

alter table products disable trigger discount_trigger;

insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);
--1	"product_3"	"producer_3"	8	115
--2	"product_1"	"producer_1"	3	40
--3	"product_1"	"producer_1"	3	50

drop trigger discount_trigger on products;

create trigger tax_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax();

create or replace function tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price - price * 0.2
        where id = (select id from inserted) and count <= 5;
        return new;
    END;
$$
LANGUAGE 'plpgsql';

------------------------------------------------------------------------------------------
--  1)  Trigger dolzhen srabatyvat posle vstavki dannyh, dlja ljubogo tovara i prosto naschityvat
--   nalog na tovar (nuzhno pribavit' nalog k cene tovara). Dejstvovat' on dolzhen ne na kazhdyj rjad,
--    a na zapros (statement uroven')

create or replace function tax_plus20_state()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.2;
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_plus20_state_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax_plus20_state();

--1	"product_3"	"producer_3"	8	115
--2	"product_1"	"producer_1"	3	40
--3	"product_1"	"producer_1"	3	50

insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 1, 50);

--1	"product_3"	"producer_3"	8	138
--2	"product_1"	"producer_1"	3	48
--3	"product_1"	"producer_1"	3	60
--4	"product_2"	"producer_2"	1	48
insert into products (name, producer, count, price) VALUES ('product_1', 'producer_3', 10, 150);

--1	"product_3"	"producer_3"	8	166
--2	"product_1"	"producer_1"	3	58
--3	"product_1"	"producer_1"	3	72
--4	"product_2"	"producer_2"	1	58
--5	"product_1"	"producer_3"	10	180

drop trigger tax_plus20_state_trigger on products;

--        2) Trigger dolzhen srabatyvat' do vstavki dannyh i naschityvat' nalog na tovar (nuzhno pribavit' nalog k cene tovara). Zdes' ispol'zuem row
--uroven'.

create or replace function tax_plus20_row()
    returns trigger as
$$
    BEGIN
        new.price = new.price + new.price * 0.2;
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_plus20_row_trigger
    before insert on products
    for each row
    execute procedure tax_plus20_row();

-- 3

create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

--Nuzhno napisat' trigger na row urovne, kotoryj srazu posle vstavki produkta v tablicu products, budet zanosit' imja, cenu i tekushhuju datu v tablicu
--history_of_price.

create or replace function adding_to_history()
    returns trigger as
$$
    BEGIN
        insert into history_of_price(name, price, date)
        values (new.name, new.price, current_timestamp(0));
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger adding_to_history_row_trigger
    after insert on products
    for each row
    execute procedure adding_to_history();