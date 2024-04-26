CREATE TABLE customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);

INSERT INTO customers(first_name, last_name, age, country) 
VALUES ('Ивонов', 'Иванов', 43, 'Беларусь'),
       ('Дмитрий', 'Дмитрий', 31, 'Россия'),
       ('Константин', 'Константин', 23, 'Грузия'),
       ('Сергей', 'Сергей', 27, 'Беларусь');

SELECT * FROM customers
WHERE age = (SELECT MIN(age) FROM customers);

CREATE TABLE orders
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

INSERT INTO orders(amount, customer_id) 
VALUES (1500, 1),
       (2000, 2),
       (3000, 3);

SELECT * FROM customers c
WHERE c.id NOT IN (SELECT o.customer_id FROM orders o);