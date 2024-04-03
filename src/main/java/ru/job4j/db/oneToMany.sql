create table cars(
    id serial primary key,
    model varchar(255)
);

create table person(
    id serial primary key,
    name varchar(255),
    car_id int references cars(id)
);