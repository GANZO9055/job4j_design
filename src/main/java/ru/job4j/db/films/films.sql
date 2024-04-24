create table new_people
(
    id serial primary key,
    full_name text,
    adress text,
    film_id int references films(id),
    sex text
);

create table films
(
    id serial primary key,
    name text
);

insert into films(name) 
values ('Пираты Карибского моря'),
       ('Матрица: Революция'),
       ('Человек, который изменил все'),
       ('Интерстеллар');

insert into new_people(full_name, adress, film_id, sex)
values ('Ольга Егоровна', '1-ый Казанский переулок, д.14', 1, 'Ж'),
       ('Ольга Егоровна', '1-ый Казанский переулок, д.14', 2, 'Ж'),
       ('Иванов Сергей', 'ул.Центральная, д.40, кв.74', 3, 'М'),
       ('Иванов Сергей', 'ул.Центральная, д.40, кв.74', 4, 'М'),
       ('Иванов Сергей', 'ул.Ленина, д.7, кв.130', 2, 'М');