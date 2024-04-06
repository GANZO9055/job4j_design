create table roles(
    id serial primary key,
    role text
);
create table rules(
    id serial primary key,
    rule text
);
create table roles_rules(
    id serial primary key,
    rules_id integer references rules(id),
    roles_id integer references roles(id)
);
create table users(
    id serial primary key,
    name text,
    role_id integer references roles(id)
);
create table categories(
    id serial primary key,
    categorie text
);
create table states(
    id serial primary key,
    state text
);
create table items(
    id serial primary key,
    item text,
    user_id integer references users(id),
    categorie_id integer references categories(id),
    state_id integer references states(id)
);
create table comments(
    id serial primary key,
    comment text,
    item_id integer references items(id)
);
create table attachs(
    id serial primary key,
    attach text,
    item_id integer references items(id)
);