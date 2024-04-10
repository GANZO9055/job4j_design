create table airports(
    id serial primary key,
    name text
);

create table plane(
    id serial primary key,
    name text,
    people int,
    airport_id int references airports(id)
);

insert into airports(name) 
values('Airport_1'),
      ('Airport_2'),
      ('Airport_3');

insert into plane(name, people, airport_id) 
values('Plane_1', 214, 1),
      ('Plane_2', 178, 2),
      ('Plane_3', 201, 1),
      ('Plane_4', 89, 3),
      ('Plane_5', 114, 2);

select * from plane as pn
join airports as airp on pn.airport_id = airp.id order by people asc;

select * from plane as pn
join airports as airp on pn.people > 150 and pn.airport_id = airp.id;

select * from plane
join airports on plane.name like '%3' limit 1;