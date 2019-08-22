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

create table if not exists business_client
(
    id bigint auto_increment
        primary key,
    business_name varchar(255) not null,
    business_products varchar(255) not null,
    business_sector varchar(255) not null,
    business_type varchar(255) not null,
    created_at datetime not null,
    date_of_incorporation date not null,
    account_number varchar(255) null,
    email varchar(255) null,
    gps_address varchar(255) null,
    house_number varchar(255) null,
    id_number varchar(255) null,
    nearest_landmark varchar(255) null,
    number_of_dependants int not null,
    phone_number varchar(255) null,
    postal_address varchar(255) null,
    tenancy_duration int not null,
    tenancy_type varchar(255) null,
    town varchar(255) null,
    updated_at datetime not null,
    user_id bigint null,
    constraint FK7mpw1ttxlx9hv301idta9b5wb
        foreign key (user_id) references user (id)
);

create table if not exists individual_client
(
    id bigint auto_increment
        primary key,
    age int not null,
    created_at datetime not null,
    date_of_birth date null,
    first_name varchar(255) not null,
    gender varchar(255) not null,
    marital_status varchar(255) not null,
    middle_name varchar(255) null,
    nationality varchar(255) not null,
    next_of_kin varchar(255) not null,
    occupation varchar(255) not null,
    account_number varchar(255) null,
    email varchar(255) null,
    gps_address varchar(255) null,
    house_number varchar(255) null,
    id_number varchar(255) null,
    nearest_landmark varchar(255) null,
    number_of_dependants int not null,
    phone_number varchar(255) null,
    postal_address varchar(255) null,
    tenancy_duration int not null,
    tenancy_type varchar(255) null,
    town varchar(255) null,
    place_of_birth varchar(255) not null,
    surname varchar(255) not null,
    updated_at datetime not null,
    branch_id bigint null,
    user_id bigint null,
    constraint FKgwkodbd8bpf31b85t0k7wn9vj
        foreign key (branch_id) references branch (id),
    constraint FKhjffx5042742pf5f6ya8lifrg
        foreign key (user_id) references user (id)
);

create table if not exists branch_clients
(
    branch_id bigint not null,
    clients_id bigint not null,
    constraint UK_bfcew5e27t2yvc1q2tpth4qho
        unique (clients_id),
    constraint FKek43iffo9uf8tnb4lvcgthyrf
        foreign key (clients_id) references individual_client (id),
    constraint FKjubm6r0gk394bc7dgjonvsul8
        foreign key (branch_id) references branch (id)
);

create table if not exists user_clients
(
    user_id bigint not null,
    clients_id bigint not null,
    constraint UK_n9d4a294yhpk9t2vb2vo2jmjl
        unique (clients_id),
    constraint FKkv83jglh3ve4a65an1oacwxwb
        foreign key (user_id) references user (id),
    constraint FKl12w87ndv3eagnnmbmwtfhysh
        foreign key (clients_id) references individual_client (id)
);

