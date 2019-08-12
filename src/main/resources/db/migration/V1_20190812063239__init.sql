create table if not exists branch
(
    id     bigint       not null primary key,
    area       varchar(255) not null,
    created_at datetime     null,
    region     varchar(255) not null,
    updated_at datetime     null,
    constraint UK_dxnfre7x5qyaka91m2i5lhd2c
        unique (region),
    constraint UK_opt21j78ki2wx3mu1vpbtkcbl
        unique (area)
) engine = innoDB CHARSET =utf8;

create table if not exists branch_users
(
    branch_id bigint not null,
    users_id  bigint not null,
    constraint UK_9v470dqo9sk93qn7vmcqlxutc
        unique (users_id)
)  engine = innoDB CHARSET =utf8;

create index FKflwfa93i5mv30w5yfbq8gk6f1
    on branch_users (branch_id);

create table if not exists business_client
(
    id                    bigint       not null
        primary key,
    business_name         varchar(255) not null,
    business_products     varchar(255) not null,
    business_sector       varchar(255) not null,
    business_type         varchar(255) not null,
    created_at            datetime     null,
    date_of_incorporation date         null,
    account_number        varchar(255) null,
    email                 varchar(255) null,
    gps_address           varchar(255) null,
    house_number          varchar(255) null,
    nearest_landmark      varchar(255) null,
    number_of_dependants  int          not null,
    phone_number          varchar(255) null,
    postal_address        varchar(255) null,
    tenancy_duration      int          not null,
    tenancy_type          varchar(255) null,
    town                  varchar(255) null,
    updated_at            datetime     null,
    user_id               bigint       null
)  engine = innoDB CHARSET =utf8;

create index FK7mpw1ttxlx9hv301idta9b5wb
    on business_client (user_id);


create table if not exists personal_client
(
    id                   bigint       not null
        primary key,
    age                  int          not null,
    created_at           datetime     null,
    date_of_birth        date         null,
    first_name           varchar(255) not null,
    gender               varchar(255) not null,
    marital_status       varchar(255) not null,
    middle_name          varchar(255) null,
    nationality          varchar(255) not null,
    next_of_kin          varchar(255) not null,
    occupation           varchar(255) not null,
    account_number       varchar(255) null,
    email                varchar(255) null,
    gps_address          varchar(255) null,
    house_number         varchar(255) null,
    nearest_landmark     varchar(255) null,
    number_of_dependants int          not null,
    phone_number         varchar(255) null,
    postal_address       varchar(255) null,
    tenancy_duration     int          not null,
    tenancy_type         varchar(255) null,
    town                 varchar(255) null,
    place_of_birth       varchar(255) not null,
    surname              varchar(255) not null,
    updated_at           datetime     null,
    user_id              bigint       null
)  engine = innoDB CHARSET =utf8;

create index FK53e4ov2x69wn4l0v2hac0kple
    on personal_client (user_id);

create table if not exists user
(
    id          bigint       not null
        primary key,
    created_at  datetime     null,
    firstname   varchar(255) not null,
    middlename  varchar(255) null,
    password    varchar(255) not null,
    permissions varchar(255) null,
    roles       varchar(255) null,
    status      int          null,
    surname     varchar(255) not null,
    updated_at  datetime     null,
    username    varchar(255) not null,
    branch_id   bigint       null
)
    engine = innoDB CHARSET =utf8;
create index FK9yy0ya980j002yvtxi9r7kv6b
    on user (branch_id);

create table if not exists user_clients
(
    user_id    bigint not null,
    clients_id bigint not null,
    constraint UK_n9d4a294yhpk9t2vb2vo2jmjl
        unique (clients_id)
)
    engine = innoDB CHARSET =utf8;
create index FKkv83jglh3ve4a65an1oacwxwb
    on user_clients (user_id);

create table if not exists hibernate_sequence
(
    next_val bigint null
)
    engine = innoDB CHARSET =utf8;


insert into hibernate_sequence values (2);
insert into hibernate_sequence values (2);
insert into hibernate_sequence values (2);
insert into hibernate_sequence values (2);

