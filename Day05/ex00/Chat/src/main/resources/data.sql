insert into users (user_login, user_password) values ('Jecka1', '123'),
                                                     ('Jecka2', '123'),
                                                     ('Jecka3', '123'),
                                                     ('Jecka4', '123'),
                                                     ('Jecka5', '123');
insert into chat_rooms (chat_room_name, chat_room_owner) values ('name1', 1),
                                                                ('name1', 2),
                                                                ('name1', 2),
                                                                ('name1', 2),
                                                                ('name1', 5);
insert into messages (message_author, message_room,
                      message_text, message_data) values (1, 1, 'hi! - 1', now()),
                                                         (2, 1, 'hi! - 2', now()),
                                                         (3, 1, 'hi! - 3', now()),
                                                         (4, 1, 'hi! - 4', now()),
                                                         (5, 1, 'hi! - 5', now());
