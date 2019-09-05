create table if not exists guarantor
(
    id            bigint       not null primary key auto_increment,
    first_name    varchar(255) not null,
    middle_name   varchar(255) not null,
    surname       varchar(255) not null,
    house_number  varchar(255) not null,
    mobile_number varchar(255) not null,
    relationship  varchar(255) not null,
    loan_id       bigint   null references loan(id)
)
