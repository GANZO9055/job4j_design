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
VALUES ('product_5', 'producer_6', 8, 100);

create or replace
procedure delete_data(d_id int)
language plpgsql as
$$
    begin
        delete from products
        where id = d_id;
    end;
$$;

call delete_data(3);
select * from products;
drop procedure delete_data(d_id int);

create or replace
function f_delete_data(d_count int)
returns void
language plpgsql as
$$
    begin
        delete from products
        where count > d_count;
    end;
$$;

select f_delete_data(5);
select * from products;