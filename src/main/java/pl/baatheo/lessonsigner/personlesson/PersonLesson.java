package pl.baatheo.lessonsigner.personlesson;


import lombok.Getter;
import lombok.Setter;
import pl.baatheo.lessonsigner.internal.model.BaseEntity;
import pl.baatheo.lessonsigner.lesson.Lesson;
import pl.baatheo.lessonsigner.person.Person;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "person_lesson")
public class PersonLesson extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_person", nullable = false)
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_lesson", nullable = false)
    private Lesson lesson;
}
