create table devices
(
    id    serial primary key,
    name  varchar(255),
    price float
);

create table people
(
    id   serial primary key,
    name varchar(255)
);

create table devices_people
(
    id        serial primary key,
    device_id int references devices (id),
    people_id int references people (id)
);

insert into devices(name, price) 
values ('HonorMac_1', 2500),
       ('HonorMac_2', 3000),
       ('HonorMac_3', 5100);
insert into devices(name, price) 
values ('Phone_1', 1500),
       ('Phone_2', 2000),
       ('Phone_3', 2500);
insert into people(name) 
values ('Alexsandr'),
       ('Andrey'),
       ('Dmitriy');
insert into devices_people(device_id, people_id)
values (3, 1),
       (5, 2),
       (2, 3);

select avg(price) from devices;

select dp.people_id, avg(d.price)
from devices d
join devices_people as dp
on dp.device_id = d.id
group by dp.people_id
order by dp.people_id asc;

select dp.people_id, avg(d.price)
from devices d
join devices_people as dp
on dp.device_id = d.id
group by dp.people_id
having avg(d.price) > 5000
order by dp.people_id asc;