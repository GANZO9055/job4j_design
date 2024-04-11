CREATE TABLE type(
    id serial primary key,
    name text
);

CREATE TABLE product(
    id serial primary key,
    name text,
    type_id int references type(id),
    expired_date date,
    price int
);

insert into type(name) 
values('СЫР'),
      ('МОЛОКО');
insert into product(name, type_id, expired_date, price)
values('Сыр плавленный', 1, '02.08.2024', 214),
      ('Сыр сулугуни', 1, '18.09.2024', 318),
      ('мороженое Большой Папа', 2, '27.09.2024', 107),
      ('Советское мороженое', 2, '18.08.2024', 156),
      ('Российское мороженое. Отборное.', 2, '19.10.2024', 199),
      ('Сыр моцарелла', 1, '21.08.2024', 301);

select * from product
where type_id = 1;

select * from product
where name like '%мороженое%';

select * from product
where expired_date < '01.09.2024';

select * from product
order by price desc limit 1;

select type_id, count(type_id)
from product
group by type_id;

insert into type(name)
values('ХЛЕБ');
insert into product(name, type_id, expired_date, price)
values('Пшеничный хлеб', 3, '13.08.2024', 59),
      ('Чесночный хлеб', 3, '29.09.2024', 78),
      ('Хлеб_1', 3, '29.09.2024', 78),
      ('Хлеб_2', 3, '29.09.2024', 78),
      ('Хлеб_3', 3, '29.09.2024', 78),
      ('Хлеб_4', 3, '29.09.2024', 78),
      ('Хлеб_5', 3, '29.09.2024', 78),
      ('Хлеб_6', 3, '29.09.2024', 78),
      ('Хлеб_7', 3, '29.09.2024', 78),
      ('Хлеб_8', 3, '29.09.2024', 78),
      ('Хлеб_9', 3, '29.09.2024', 78);

select * from product
where type_id in (1, 2)
order by type_id;

select type_id, count(type_id)
from product
group by type_id
having count(type_id) < 10;

select name, type_id
from product
order by type_id;

select * from type;
select * from product;