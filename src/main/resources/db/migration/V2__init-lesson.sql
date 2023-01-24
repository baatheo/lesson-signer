create table lesson
(
    id bigserial not null
        constraint lesson_pk primary key,
    id_subject bigserial not null
        constraint lesson_subject_id_fk
            references subject on delete cascade,
    start_date timestamp not null
);

alter table lesson
    owner to vpxzmizstxfutq;

grant delete, insert, select, update on lesson to vpxzmizstxfutq;