create table if not exists branch
(
    id bigint auto_increment
        primary key,
    area varchar(255) not null,
    created_at datetime not null,
    region varchar(255) not null,
    updated_at datetime not null,
    constraint UK_dxnfre7x5qyaka91m2i5lhd2c
        unique (region),
    constraint UK_opt21j78ki2wx3mu1vpbtkcbl
        unique (area)
);

create table if not exists user
(
    id bigint auto_increment
        primary key,
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
    branch_id bigint null,
    constraint FK9yy0ya980j002yvtxi9r7kv6b
        foreign key (branch_id) references branch (id)
);

create table if not exists branch_users
(
    branch_id bigint not null,
    users_id bigint not null,
    constraint UK_9v470dqo9sk93qn7vmcqlxutc
        unique (users_id),
    constraint FKewjisg95kei050opnewm6eo91
        foreign key (users_id) references user (id),
    constraint FKflwfa93i5mv30w5yfbq8gk6f1
        foreign key (branch_id) references branch (id)
);
