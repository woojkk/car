drop table if exists car;
create table car(
    id bigint auto_increment primary key,
    model_name varchar(255) not null,
    company_id bigint not null,
    passenger_capacity int,
    created_at timestamp not null,
    updated_at timestamp not null,
);

drop table if exists company;
create table company(
    id bigint auto_increment primary key,
    company_name varchar(255) not null,
    company_nation varchar(255) not null,
    created_at timestamp not null,
    updated_at timestamp not null
);