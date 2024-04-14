create table departments(
    id serial primary key,
    name text
);

create table employees(
    id serial primary key,
    name text,
    department_id int references departments(id)
);

insert into departments(name)
values('department_1'),
      ('department_2'),
      ('department_3'),
      ('department_4');

insert into employees(name, department_id)
values ('Николай', 1),
       ('Игорь', 2),
       ('Константин', 3),
       ('Алексей', 2),
       ('Георгий', 1),
       ('Дмитрий', 1);

select * from departments d
left join employees em on d.id = em.department_id;

select * from employees em
right join departments d on d.id = em.department_id;

select * from departments d
full join employees em on d.id = em.department_id;

select * from departments
cross join employees;

select distinct * from departments d
left join employees em on d.id = em.department_id
where em.department_id is null;

select * from departments d
left join employees em on d.id = em.department_id
where em.department_id is not null;
select * from departments d
right join employees em on d.id = em.department_id

create table teens(
    id serial primary key,
    name text,
    gender text
);

insert into teens(name, gender)
values('Маша', 'Ж'),
      ('Вика', 'Ж'),
      ('Аня', 'Ж'),
      ('Дима', 'М'),
      ('Сергей', 'М'),
      ('Коля', 'М');

select t1.name, t2.name from teens t1
        cross join teens t2
where t1.gender != t2.gender
        and t1.gender != 'М';