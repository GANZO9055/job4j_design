create table cars(
    id serial primary key,
    model varchar(255)
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table people_cars(
    id serial primary key,
    person_id int references people(id),
    car_id int references cars(id)
);
