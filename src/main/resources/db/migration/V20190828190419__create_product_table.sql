create table if not exists product(
    id bigint auto_increment primary key,
    name varchar(255) not null ,
    minimum_amount double not null ,
    maximum_amount double not null,
    repayment_period integer not null,
    interest_rate double not null
) ENGINE INNODB;
