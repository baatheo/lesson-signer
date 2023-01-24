create table subject
(
    id    bigserial    not null
        constraint subject_pk primary key,
    name  varchar(50)  not null,
    owner varchar(100) not null
);

create unique index subject_name_uindex on subject(name);

create index subject_name_index on subject (name);

create index subject_owner_index on subject (owner);

alter table subject
    owner to vpxzmizstxfutq;

grant delete, insert, select, update on subject to vpxzmizstxfutq;