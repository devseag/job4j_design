create table teens(
id serial primary key,
name text,
gender character
);
insert into teens(name,gender) values('Sam','M');
insert into teens(name,gender) values('Amelia','F');
insert into teens(name,gender) values('Jack','M');
insert into teens(name,gender) values('Lidia','F');

select (t.name,t.gender),(t1.name,t1.gender) from teens t cross join teens t1
where t.gender!=t1.gender;

--(Sam,M)	(Amelia,F)
--(Sam,M)	(Lidia,F)
--(Amelia,F)	(Sam,M)
--(Amelia,F)	(Jack,M)
--(Jack,M)	(Amelia,F)
--(Jack,M)	(Lidia,F)
--(Lidia,F)	(Sam,M)
--(Lidia,F)	(Jack,M)