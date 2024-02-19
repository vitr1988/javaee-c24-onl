-- Заполняем таблицу ролей и создаем пользователя с такой ролью
insert into roles(name) values ('ADMIN');
insert into users(user_name, login, password, status, role_id)
values ('admin', 'admin', '$2a$10$Gq4Gjp73EBMFcm4Bq5G7i..XCUfMif5u69EvJKCaJlNVzvzZb2lVO', 'OK', select id from roles where name = 'ADMIN');

insert into roles(name) values ('GUEST');
insert into users(user_name, login, password, status, role_id)
values ('guest', 'guest', '$2a$10$NVQrP6gBwKh/.FI3G11EZOpcw586cFcfxrHM7fLlo4N6Bj7UCxO5i', 'OK', select id from roles where name = 'GUEST');

insert into roles(name) values ('USER');
insert into users(user_name, login, password, status, role_id)
values ('user', 'user', '$2a$10$wBTxLBJmAzb79jFCImNFEu81Vqi7r3jH1QwfA8FtFJRgTvl8odAFe', 'OK', select id from roles where name = 'USER');
