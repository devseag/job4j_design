create table subject(
	id serial primary key,
	name varchar(55)
);
create table student(
	id serial primary key,
	first_name varchar(255),
	last_name varchar(255)

);
create table rating(
	id serial primary key,
	assessment char(1)
);
create table study_class(
	id serial primary key,
	student_id int references student(id),
	subject_id int references subject (id),
	rating_id int references rating (id)
);
insert into subject (name) values ('Mathematics');
insert into subject (name) values ('Physics');
insert into subject (name) values ('Chemistry');
insert into subject (name) values ('Literature');
insert into student(first_name,last_name) values('Tom','Smith');
insert into student(first_name,last_name) values('Jon','Black');
insert into student(first_name,last_name) values('Sam','Button');
insert into student(first_name,last_name) values('Will','Drake');
insert into rating(assessment) values('A');
insert into rating(assessment) values('B');
insert into rating(assessment) values('C');
insert into rating(assessment) values('D');
insert into study_class(student_id,subject_id,rating_id) values(1,1,1);
insert into study_class(student_id,subject_id,rating_id) values(1,2,2);
insert into study_class(student_id,subject_id,rating_id) values(1,3,3);
insert into study_class(student_id,subject_id,rating_id) values(1,4,4);
insert into study_class(student_id,subject_id,rating_id) values(2,2,2);
insert into study_class(student_id,subject_id,rating_id) values(2,3,4);
insert into study_class(student_id,subject_id,rating_id) values(2,1,2);
insert into study_class(student_id,subject_id,rating_id) values(3,2,2);
insert into study_class(student_id,subject_id,rating_id) values(3,3,1);
insert into study_class(student_id,subject_id,rating_id) values(4,4,4);
insert into study_class(student_id,subject_id,rating_id) values(4,1,2);

