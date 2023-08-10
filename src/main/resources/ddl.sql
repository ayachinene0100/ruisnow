create table test
(
    id bigint auto_increment primary key,
    username varchar(20) not null,
    password varchar(20) not null,
    index user_username_index(username)
);