start transaction;

update new_products
set price = 115
where name = 'product_3';

savepoint one;

delete from new_products
where name = 'product_3';

select * from new_products;

rollback to one;

select * from new_products;

commit;