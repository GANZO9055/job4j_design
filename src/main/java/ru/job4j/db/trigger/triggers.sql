create table products
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);

insert into products (name, producer, count, price)
VALUES ('product_3', 'producer_3', 8, 115);

insert into products (name, producer, count, price)
VALUES ('product_2', 'producer_2', 3, 50);

insert into products (name, producer, count, price)
VALUES ('product_1', 'producer_1', 3, 50);

create
or replace function tax()
        returns trigger as
$$
    BEGIN
        update products
        set price = price * 1.2
        where id = (select id from inserted);
        return new;
    END;
$$
language 'plpgsql';

create trigger product_tax
    after insert
    on products
    referencing new table as
                    inserted
    for each statement
    execute procedure tax();


select * from products;
drop trigger product_tax on products;

create
or replace function tax_before()
        returns trigger as
$$
    BEGIN
        update products
        set price = new.price * 1.2;
        return new;
    END;
$$
language 'plpgsql';

create trigger product_tax_before
    before insert
    on products
    for each row
    execute procedure tax_before();

insert into products (name, producer, count, price)
VALUES ('product_5', 'producer_6', 8, 100);
insert into products (name, producer, count, price)
VALUES ('product_6', 'producer_6', 10, 120);

select * from products;
drop trigger product_tax_before on products;

create table history_of_price
(
    id    serial primary key,
    name  varchar(50),
    price integer,
    date  timestamp
);

create function input_after()
returns trigger
language plpgsql as
$$
    BEGIN
        insert into history_of_price(name, price, date)
        values(new.name, new.price, now());
        return new;
    END;
$$;

create trigger write_after_input
    after insert
    on products
    for each row
    execute procedure input_after();

insert into products (name, producer, count, price)
VALUES ('product_7', 'producer_7', 11, 110);

select * from history_of_price;
drop table products;