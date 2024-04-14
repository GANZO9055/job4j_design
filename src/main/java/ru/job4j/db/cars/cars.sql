create table car_bodies(
    id serial primary key,
    name text
);

create table car_engines(
    id serial primary key,
    name text
);

create table car_transmissions(
    id serial primary key,
    name text
);

create table cars(
    id serial primary key,
    name text,
    body_id int references car_bodies(id),
    engine_id int references car_engines(id),
    transmission_id int references car_transmissions(id)
);

insert into car_bodies(name)
values('седан'),
      ('внедорожник'),
      ('кроссовер'),
      ('пикап'),
      ('null');
insert into car_engines(name)
values('бензиновый'),
      ('дизельный'),
      ('газовый'),
      ('электрический'),
      ('null');
insert into car_transmissions(name)
values('механическая'),
      ('гидромеханическую'),
      ('роботизированную'),
      ('вариатор'),
      ('null');
insert into cars(name, body_id, engine_id, transmission_id)
values('car_1', 1, 1, 1),
      ('car_2', 2, 1, 3),
      ('car_3', 5, 4, 1),
      ('car_4', 1, 1, 5),
      ('car_5', 1, 5, 1),
      ('car_6', 3, 2, 4),
      ('car_7', 2, 4, 3),
      ('car_8', 5, 5, 5);
select * from cars;

select c.name, b.name, e.name, t.name from cars c
left join car_bodies b on c.body_id = b.id
left join car_engines e on c.engine_id = e.id
left join car_transmissions t on c.transmission_id = t.id;

select * from car_bodies b
left join cars c on b.id = c.body_id
where c.name is null;

select * from car_engines e
left join cars c on e.id = c.engine_id
where c.name is null;

select * from car_transmissions t
left join cars c on t.id = c.transmission_id
where c.name is null;