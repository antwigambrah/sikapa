
create table branch
(
    id bigint auto_increment  primary key,
    area varchar(255) not null unique ,
    created_at datetime not null,
    region varchar(255) not null unique ,
    updated_at datetime not null
) ENGINE INNODB charset =utf8;

create table  user
(
    id bigint auto_increment  primary key,
    created_at datetime not null,
    firstname varchar(255) not null,
    middlename varchar(255) null,
    password varchar(255) not null,
    permissions varchar(255) null,
    roles varchar(255) not null,
    status int not null,
    surname varchar(255) not null,
    updated_at datetime not null,
    username varchar(255) not null,
    branch_id bigint not null references branch(id)
) ENGINE INNODB;

create table branch_users
(
    branch_id bigint not null references branch(id),
    users_id bigint not null references user(id)
) ENGINE INNODB;
