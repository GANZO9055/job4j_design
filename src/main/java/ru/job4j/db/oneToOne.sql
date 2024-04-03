create table document_for_car(
    id serial primary key,
    seria int,
    numbber int,
    model varchar(255)
);

create table person(
    id serial primary key,
    name varchar(255),
    document_id int references document_for_car(id)
);
