drop table if exists phones cascade;
drop table if exists users cascade;

create table phones (
    id bigint generated by default as identity,
    user_id uuid not null,
    citycode varchar(255) not null,
    countrycode varchar(255) not null,
    number varchar(255) not null,
    primary key (id)
);

create table users (
    is_active boolean,
    created timestamp(6) not null,
    last_login timestamp(6),
    modified timestamp(6),
    id uuid not null,
    created_by varchar(255),
    email varchar(255),
    modified_by varchar(255),
    name varchar(255),
    password varchar(255),
    token varchar(255),
    primary key (id)
);

alter table if exists phones
   add constraint FKmg6d77tgqfen7n1g763nvsqe3
   foreign key (user_id)
   references users;
