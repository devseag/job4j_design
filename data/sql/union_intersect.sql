SELECT first_select_query
set_operator
SELECT second_select_query;

CREATE TABLE customer (
    first_name text,
    last_name text
);

CREATE TABLE employee (
    first_name text,
    last_name text
);

INSERT INTO customer
VALUES ('Ivan', 'Ivanov'),
       ('Petr', 'Sergeev'),
       ('Irina', 'Brosova'),
       ('Anna', 'Opushkina'),
       ('Potap', 'Potapov');

INSERT INTO employee
VALUES ('Kristina', 'Pozova'),
       ('Mihail', 'Krugov'),
       ('Anna', 'Opushkina'),
       ('Ivan', 'Ivanov'),
       ('Sergej', 'Petrov');

SELECT first_name, last_name
FROM customer
UNION
SELECT first_name, last_name
FROM employee;

SELECT first_name, last_name
FROM customer
UNION
SELECT first_name, last_name
FROM employee
ORDER BY first_name, last_name;

SELECT first_name, last_name
FROM customer
WHERE status = 'Active'
UNION
SELECT first_name, last_name
FROM employee
WHERE emp_status = 'Current'
ORDER BY first_name, last_name;

-- with JOIN:
SELECT
    e.first_name,
    e.last_name,
    c.first_name,
    c.last_name
FROM employee e
         INNER JOIN customer c
                    ON e.first_name = c.first_name
                        AND e.last_name = c.last_name;

SELECT first_name, last_name
FROM customer
UNION
SELECT first_name, last_name
FROM employee;

--pri JOIN dannye iz prisoedinjaemoj tablicy otrazhajutsja v novyh stolbcah rezul'tatov vyborki, kak by prisoedinjajas'
--sprava. V UNION zhe u nas idut tol'ko stolbcy iz pervoj tablicy, a dannye iz vtoroj prosto otrazhajutsja nizhe, posle
--dannyh ih pervoj tablicy.

SELECT first_name, last_name
FROM customer
UNION ALL
SELECT first_name, last_name
FROM employee

SELECT first_name, last_name
FROM customer
EXCEPT
SELECT first_name, last_name
FROM employee;

SELECT first_name, last_name
FROM customer
INTERSECT
SELECT first_name, last_name
FROM employee;


CREATE TABLE referrer (
    first_name text,
    last_name text
);
INSERT INTO referrer
VALUES ('Evgenij', 'Onegin'),
       ('Petr', 'Sergeev'),
       ('Aleksandr', 'Ozhegov'),
       ('Anna', 'Opushkina'),
       ('Mihail', 'Krugov');

SELECT first_name, last_name
FROM customer
UNION
SELECT first_name, last_name
FROM employee
UNION
SELECT first_name, last_name
FROM referrer
ORDER BY first_name, last_name;

SELECT first_name, last_name
FROM customer
UNION ALL
SELECT first_name, last_name
FROM employee
EXCEPT
SELECT first_name, last_name
FROM referrer
ORDER BY first_name, last_name;

-- for INTERSECT only:

--zapros
--
--zapros1 UNION zapros2 INTERSECT zapros3
--
--dast tot zhe rezul'tat, chto i
--
--zapros1 UNION (zapros2 INTERSECT zapros3)

CUSTOMER + (EMPLOYEE - REFERRER)

SELECT first_name, last_name
FROM customer
UNION ALL
(SELECT first_name, last_name
FROM employee
EXCEPT
SELECT first_name, last_name
FROM referrer)
ORDER BY first_name, last_name;

