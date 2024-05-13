CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

SELECT * FROM company;
SELECT * FROM person;

INSERT INTO company (id, name) values (1, 'company_1');
INSERT INTO company (id, name) values (2, 'company_2');
INSERT INTO company (id, name) values (3, 'company_3');
INSERT INTO company (id, name) values (4, 'company_4');
INSERT INTO company (id, name) values (5, 'company_5');

INSERT INTO person (id, name, company_id) values (1, 'person_1', 1);
INSERT INTO person (id, name, company_id) values (2, 'person_2', 1);
INSERT INTO person (id, name, company_id) values (3, 'person_3', 1);
INSERT INTO person (id, name, company_id) values (4, 'person_4', 3);
INSERT INTO person (id, name, company_id) values (5, 'person_5', 3);
INSERT INTO person (id, name, company_id) values (6, 'person_6', 2);
INSERT INTO person (id, name, company_id) values (7, 'person_7', 4);
INSERT INTO person (id, name, company_id) values (8, 'person_8', 4);
INSERT INTO person (id, name, company_id) values (9, 'person_9', 4);

select p.name, c.name from person p
left join company c on p.company_id = c.id
where p.company_id != 5;

select c.name, count(p.company_id) from person p
left join company c on p.company_id = c.id
group by c.name
order by count(p.company_id) desc
limit 2;