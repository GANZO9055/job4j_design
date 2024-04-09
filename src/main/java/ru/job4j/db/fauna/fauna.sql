create table fauna
(
    id             serial primary key,
    name           text,
    avg_age        int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date)
values('AD', 15000, '02.05.2001'),
      ('AB', 10000, '25.01.2021'),
      ('BD', 21500, '16.03.2016'),
      ('BC', 19300, '14.07.2008'),
      ('DA', 11000, '28.06.2005');

select * from fauna where name like 'fish';
select * from fauna where name like 'B%';
select * from fauna where avg_age > 10000 and avg_age < 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date is not null;
select * from fauna where discovery_date < '01.01.1950';
select * from fauna where discovery_date < '01.01.2015';