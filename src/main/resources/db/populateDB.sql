delete from user_roles;
delete from restaurants;
delete from users;
alter sequence global_seq RESTART with 100000;

insert into users (name, email, password) values
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

insert into user_roles (role, user_id) values
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);


insert into restaurants (name) values
  ('Планета чебуреков'),
  ('Гречкин дом');


insert into dishes (datetime, name, restaurant_id)
values ('2020-01-10', 'Чебурек с сыром', 100002),
       ('2020-01-10', 'Пепси', 100002),
       ('2020-01-10', 'Гречка', 100003),
       ('2020-01-10', 'Отбивная', 100003),
       ('2020-01-11', 'Бутерброд', 100002),
       ('2020-01-11', 'Чай', 100002),
       ('2020-01-11', 'Гречневые блины', 100003),
       ('2020-01-11', 'Компот', 100003);

insert into votes (datetime, user_id, restaurant_id)
values ('2020-01-10 10:00:00', 100000, 100002),
       ('2020-01-10 10:00:00', 100001, 100003),
       ('2020-01-11 10:00:00', 100000, 100003),
       ('2020-01-11 10:00:00', 100001, 100003);
