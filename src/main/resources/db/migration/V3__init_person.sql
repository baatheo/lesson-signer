create table person
(
    id         bigserial    not null
        constraint person_pk primary key,
    first_name varchar(50)  not null,
    last_name  varchar(100) not null,
    index      varchar(6)   not null
);

create index person_index_index on person (index);

alter table person
    owner to vpxzmizstxfutq;

grant delete, insert, select, update on person to vpxzmizstxfutq;