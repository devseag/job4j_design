CREATE TABLE companies(
    id int primary key,
    city text
);

CREATE TABLE goods(
    id int primary key,
    name text,
    company_id int references companies(id),
    price int
);

CREATE TABLE sales_managers(
    id int primary key,
    last_name text,
    first_name text,
    company_id int references companies(id),
    manager_fee int
);

CREATE TABLE managers(
    id int primary key,
    company_id int references companies(id)
);

INSERT INTO companies VALUES (1, 'Moskva'),
                             (2, 'N'ju-Jork'),
                             (3, 'Mjunhen');

INSERT INTO goods VALUES (1, 'Nebol'shaja kvartira', 3, 5000),
                         (2, 'Kvartira v centre', 1, 4500),
                         (3, 'Kvartira u metro', 1, 3200),
                         (4, 'Loft', 2, 6700),
                         (5, 'Zagorodnyj dom', 2, 9800);

INSERT INTO sales_managers VALUES (1, 'Dou', 'Dzhon', 2, 2250),
                                  (2, 'Gruber', 'Gans', 3, 3120),
                                  (3, 'Smit', 'Sara', 2, 1640),
                                  (4, 'Ivanov', 'Ivan', 1, 4500),
                                  (5, 'Kuper', 'Greta', 3, 2130);

INSERT INTO managers VALUES (1, 2),
                            (2, 3),
                            (4, 1);

SELECT * FROM sales_managers
WHERE manager_fee > (SELECT AVG(manager_fee) FROM sales_managers);

SELECT name AS real_estate, price, (SELECT AVG(price) FROM goods) AS avg_price FROM goods;

SELECT AVG(manager_fee)
FROM sales_managers WHERE sales_managers.id NOT IN (SELECT managers.id FROM managers);

SELECT city, (SELECT count(*) FROM goods as g
WHERE c.id = g.company_id) as total_goods FROM companies c;
--THE SAME:
SELECT c.city, COUNT(g.name) AS total_goods FROM companies c
    JOIN goods g ON c.id = g.company_id GROUP BY c.city;
-- JOIN’y obychno vypolnjajutsja bystree, chem podzaprosy. Odnako, esli dlja vas podzaprosy javljajutsja bolee intuitivno
--ponjatnymi dlja konkretnogo sluchaja, to ih mozhno ispol'zovat'.

SELECT last_name, first_name, manager_fee
FROM sales_managers sm1
WHERE sm1.manager_fee >= (SELECT AVG(manager_fee)
                            FROM sales_managers sm2
                            WHERE sm2.company_id = sm1.company_id);

SELECT company_id, AVG(price) AS average_price
FROM goods
GROUP BY company_id
HAVING AVG(price) > (SELECT MAX(price) FROM goods) / 2;

