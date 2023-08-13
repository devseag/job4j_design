create table kuzov(
id serial primary key,
name text
);
create table dvigatel(
id serial primary key,
name text
);
create table k_peredach(
id serial primary key,
name text
);
create table mashina(
id serial primary key,
name text,
kuzov_id int references kuzov(id),
dvigatel_id int references dvigatel(id),
k_peredach_id int references k_peredach(id)
);
insert into kuzov(name) values ('one');
insert into dvigatel(name) values ('one');
insert into dvigatel(name) values ('two');
insert into dvigatel(name) values ('three');
insert into k_peredach(name) values ('one');
insert into k_peredach(name) values ('two');
insert into mashina(name,kuzov_id,dvigatel_id,k_peredach_id) values ('A',1,2,2);
insert into mashina(name,dvigatel_id) values ('B',2);
insert into mashina(name,kuzov_id,dvigatel_id) values ('C',1,2);
insert into mashina(name,kuzov_id,dvigatel_id,k_peredach_id) values ('D',1,3,1);
insert into mashina(name,kuzov_id,dvigatel_id,k_peredach_id) values ('E',1,2,2);
insert into mashina(name,dvigatel_id,k_peredach_id) values ('F',3,1);
insert into mashina(name,kuzov_id,dvigatel_id) values ('G',1,3);
insert into mashina(name,kuzov_id) values ('H',1);
insert into mashina(name,kuzov_id,dvigatel_id,k_peredach_id) values ('I',1,1,1);
insert into mashina(name) values ('O');

/*Vyvesti spisok vseh mashin i vse privjazannye k nim detali. Nuzhno uchest', chto kakih-to detalej mashina mozhet i ne soderzhat'.*/
select m.name mashina_name,
k.name korobka_peredach_name,
d.name dvigatel_name
from mashina m
left join kuzov k on m.kuzov_id = k.id
left join dvigatel d on m.dvigatel_id = d.id
left join k_peredach kp on m.k_peredach_id = kp.id;

/*Vyvesti otdel'no detali (1 detal' - 1 zapros), kotorye ne ispol'zujutsja NI v odnoj mashine, kuzova, dvigateli, korobki peredach.*/
select k.name k_peredach_name
from mashina m
right join k_peredach k on k.id = m.k_peredach_id
where m.k_peredach_id is null;

select k.name kuzov_name
from mashina m
right join kuzov k on k.id = m.kuzov_id
where m.kuzov_id is null;

select d.name dvigatel_name
from mashina m
right join dvigatel d on d.id = m.dvigatel_id
where m.dvigatel_id is null;