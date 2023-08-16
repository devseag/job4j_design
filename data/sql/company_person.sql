CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);
CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);
insert into company (name, id) values ('one',1);
insert into company (name, id) values ('two',2);
insert into company (name, id) values ('three',3);
insert into company (name, id) values ('four',4);
insert into company (name, id) values ('five',5);
insert into company (name, id) values ('six',6);
insert into company (name, id) values ('seven',7);
insert into person (id, name, company_id) values (1,'petr',4);
insert into person (id, name, company_id) values (2,'vlad',2);
insert into person (id, name, company_id) values (3,'sergey',5);
insert into person (id, name, company_id) values (4,'igor',5);
insert into person (id, name, company_id) values (5,'stepav',5);
insert into person (id, name, company_id) values (6,'vsevolod',1);
insert into person (id, name, company_id) values (7,'oleg',6);
insert into person (id, name, company_id) values (8,'dmitryi',6);
insert into person (id, name, company_id) values (9,'alex',6);
insert into person (id, name, company_id) values (10,'nikita',7);
insert into person (id, name, company_id) values (11,'ostap',3);
insert into person (id, name, company_id) values (12,'timur',3);
insert into person (id, name, company_id) values (13,'semen',3);
insert into person (id, name, company_id) values (14,'anton',7);
insert into person (id, name, company_id) values (15,'artem',7);
insert into person (id, name, company_id) values (16,'denis',7);
insert into person (id, name, company_id) values (17,'danil',7);
insert into person (id, name, company_id) values (18,'kostyan',6);
insert into person (id, name, company_id) values (19,'boris',5);
insert into person (id, name, company_id) values (20,'pavel',5);

/*1. V odnom zaprose poluchit'
- imena vseh person, kotorye ne sostojat v kompanii s id = 5;
- nazvanie kompanii dlja kazhdogo cheloveka.*/

select p.name, c.name from person p
right join company c on p.company_id = c.id
where p.company_id != 5;

/*2. Neobhodimo vybrat' nazvanie kompanii s maksimal'nym kolichestvom chelovek + kolichestvo chelovek v jetoj kompanii
(nuzhno uchest', chto takih kompanij mozhet byt' neskol'ko).*/

select c.name, count(p.id) from company c
join person p on p.company_id = c.id
group by c.name
having count(p.id) = (
	select count(company_id) from person
	group by company_id
	order by count(company_id) desc
	limit 1
);

