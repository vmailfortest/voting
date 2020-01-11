DELETE FROM user_roles;
DELETE FROM restaurants;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);


INSERT INTO restaurants (name) VALUES
  ('Планета чебуреков'),
  ('Гречкин дом');


INSERT INTO dishes (datetime, name, restaurant_id)
VALUES ('2020-01-10', 'Чебурек с сыром', 100002),
       ('2020-01-10', 'Пепси', 100002),
       ('2020-01-10', 'Гречка', 100003),
       ('2020-01-10', 'Отбивная', 100003),
       ('2020-01-11', 'Бутерброд', 100002),
       ('2020-01-11', 'Чай', 100002),
       ('2020-01-11', 'Гречневые блины', 100003),
       ('2020-01-11', 'Компот', 100003);

INSERT INTO votes (datetime, user_id, restaurant_id)
VALUES ('2020-01-10 10:00:00', 100000, 100002),
       ('2020-01-10 10:00:00', 100001, 100003),
       ('2020-01-11 10:00:00', 100000, 100003),
       ('2020-01-11 10:00:00', 100001, 100003);
