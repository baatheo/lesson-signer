create table person_lesson
(
    id        bigserial not null
        constraint person_lesson_pk primary key,
    id_lesson bigserial not null
        constraint person_lesson_lesson_id_fk
            references lesson on delete cascade,
    id_person bigserial not null
        constraint person_lesson_person_id_fk
            references person on delete cascade
);

alter table person_lesson
    owner to vpxzmizstxfutq;

grant delete, insert, select, update on person_lesson to vpxzmizstxfutq;