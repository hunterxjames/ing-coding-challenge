insert into roles (name) values('ROLE_ADMIN');
insert into roles (name) values('ROLE_USER');


insert into users(id, title, first_name, last_name, gender, username, password) values(next value for user_sequence, 'Mr.', 'Leon', 'Russell', 'male', 'leonr', '$2a$10$zcDjbeU.cwCE.zfhoIl3A.liA3hsSOl0wBaoi9feD1fgQgSl9EMJO');
insert into users(id, title, first_name, last_name, gender, username, password) values(next value for user_sequence, 'Dr.', 'Aaron', 'Russell', 'male', 'aaronr', '$2a$10$zcDjbeU.cwCE.zfhoIl3A.liA3hsSOl0wBaoi9feD1fgQgSl9EMJO');
insert into users(id, title, first_name, last_name, gender, username, password) values(next value for user_sequence, 'Mr.', 'Ethan', 'Connel', 'male', 'ethanc', '$2a$10$zcDjbeU.cwCE.zfhoIl3A.liA3hsSOl0wBaoi9feD1fgQgSl9EMJO');
insert into users(id, title, first_name, last_name, gender, username, password) values(next value for user_sequence, 'Mrs.', 'Harriet', 'Monk', 'female', 'harrietm', '$2a$10$zcDjbeU.cwCE.zfhoIl3A.liA3hsSOl0wBaoi9feD1fgQgSl9EMJO');
insert into users(id, title, first_name, last_name, gender, username, password) values(next value for user_sequence, 'Mr.', 'Jayden', 'Dawson', 'male', 'jaydend', '$2a$10$zcDjbeU.cwCE.zfhoIl3A.liA3hsSOl0wBaoi9feD1fgQgSl9EMJO');
insert into users(id, title, first_name, last_name, gender, username, password) values(next value for user_sequence, 'Ms.', 'Catherine', 'Wall', 'female', 'catherinew', '$2a$10$XDQEw3c2qX2J0jWKOaWocOqAItGtj2TfNslg5JGVIE/kEnonyrwWe');

insert into address(user_id, street, city, state, postcode) values (1, '12 Insignia Way', 'Yilkari', 'Western Australia', '6430');
insert into address(user_id, street, city, state, postcode) values (2, '7 Barker Street', 'Denbarker', 'Western Australia', '6324');
insert into address(user_id, street, city, state, postcode) values (3, '76 Bellion Drive', 'Quinninup', 'Western Australia', '6258');
insert into address(user_id, street, city, state, postcode) values (4, '95 Bayview Close', 'Emu Park', 'Queensland', '4710');
insert into address(user_id, street, city, state, postcode) values (5, '6 Davenport Street', 'Kybeyan', 'New South Wales', '2631');
insert into address(user_id, street, city, state, postcode) values (6, '23 McKillop Street', 'Warrak', 'Victoria', '3377');

insert into users_roles(user_id, role_id) values(1, 1);
insert into users_roles(user_id, role_id) values(2, 2);
insert into users_roles(user_id, role_id) values(3, 2);
insert into users_roles(user_id, role_id) values(4, 2);
insert into users_roles(user_id, role_id) values(5, 2);
insert into users_roles(user_id, role_id) values(6, 1);
