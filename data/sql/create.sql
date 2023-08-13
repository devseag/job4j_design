create table state(
id serial primary key,
condition bool
);
create table category(
id serial primary key,
name varchar(50)
);
create table role(
id serial primary key,
name varchar(50)
);
create table rules(
id serial primary key,
write bool,
read bool
);
create table role_rules(
id serial primary key,
text varchar(30),
rules_id int references rules(id),
role_id int references role(id)
);
create table users(
id serial primary key,
name varchar(100),
age int,
role_id int references role(id)
);
create table item(
id serial primary key,
name varchar(40),
users_id int references users(id),
category_id int references category(id),
state_id int references state(id)
);
create table comments(
id serial primary key,
text varchar(255),
item_id int references item(id)
);
create table attachs(
id serial primary key,
date date,
item_id int references item(id)
);