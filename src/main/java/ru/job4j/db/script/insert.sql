insert into roles(role) values ('Admin');
insert into roles(role) values ('Moderator');
insert into roles(role) values ('User');

insert into rules(rule) values ('Complete');
insert into rules(rule) values ('Incomplete');
insert into rules(rule) values ('Partial');

insert into roles_rules(rules_id, roles_id) values (1, 1);
insert into roles_rules(rules_id, roles_id) values (2, 2);
insert into roles_rules(rules_id, roles_id) values (3, 3);

insert into users(name, role_id) values ('Сергей', 2);
insert into users(name, role_id) values ('Дмитрий', 1);
insert into users(name, role_id) values ('Иванов', 3);

insert into states(state) values ('Новая');
insert into states(state) values ('В работе');
insert into states(state) values ('Завершена');

insert into categories(categorie) values ('Важная');
insert into categories(categorie) values ('Обычная');

insert into items(item, user_id, categorie_id, state_id)
values ('Заявка 1', 3, 2, 1);
insert into items(item, user_id, categorie_id, state_id)
values ('Заявка 2', 1, 2, 2);
insert into items(item, user_id, categorie_id, state_id)
values ('Заявка 3', 2, 1, 3);

insert into comments(comment, item_id) values ('Комментарий 1', 1);
insert into comments(comment, item_id) values ('Комментарий 2', 2);
insert into comments(comment, item_id) values ('Комментарий 3', 2);
insert into comments(comment, item_id) values ('Комментарий 4', 3);

insert into attachs(attach, item_id) values ('Файл 1', 2);
insert into attachs(attach, item_id) values ('Файл 2', 3);
insert into attachs(attach, item_id) values ('Файл 3', 2);
insert into attachs(attach, item_id) values ('Файл 4', 1);
insert into attachs(attach, item_id) values ('Файл 5', 1);
