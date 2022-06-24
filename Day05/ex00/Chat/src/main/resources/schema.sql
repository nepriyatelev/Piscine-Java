drop table if exists users, chat_rooms, messages, users_chat_room;

CREATE TABLE users (
                            user_id bigserial primary key,
                            user_login varchar(20) NOT NULL,
                            user_password varchar(20) NOT NULL
);
CREATE TABLE chat_rooms (
                          chat_room_id bigserial primary key,
                          chat_room_name varchar(20) NOT NULL,
                          chat_room_owner bigint references users(user_id)
);
CREATE TABLE messages (
                         message_id bigserial primary key,
                         message_author bigint references users(user_id),
                         message_room bigint references chat_rooms(chat_room_id),
                         message_text varchar (200),
                         message_data timestamp
);
CREATE TABLE users_chat_room (
                       user_id bigint references users(user_id),
                       chat_room_id bigint references chat_rooms(chat_room_id)
);
