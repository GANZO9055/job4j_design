create table car (
	id serial primary key,
	model text,
	price integer,
	imported_product boolean
);
insert into car(model, price, imported_product) values ('Lada_Granta', 1500000, false);
select * from car;
update car set model = 'Cherry_Tiggo_7', price = 2500000, imported_product = true;
delete from car;