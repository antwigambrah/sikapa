create table if not exists loan(
id bigint not null auto_increment primary key ,
client_phone_number varchar(255) not null ,
client_name varchar(255)  not null ,
amount double not null ,
account_number varchar(255) not null,
commitment_fee double not null ,
insurance_premium double not null ,
start_date date not null ,
initiate_date date not null,
end_date date not null,
purpose longtext not null ,
status varchar(255) not null,
collateral varchar(255) not null,
comments  longtext not null ,
source_of_income varchar(255) not null ,
product_id bigint not null references product(id),
user_id bigint not null references user(id)
);

create  table if not exists user_loans(
    user_id bigint not null references  loan(id),
    loans_id bigint not null references  loan(id)
);
create table if not exists loan_guarantors(
    loan_id bigint not null references loan(id),
    guarantors_id bigint not null references guarantor(id)
);

create table if not exists product_loans(
    product_id bigint not null references product(id),
     loans_id bigint not null references loan(id)
);
