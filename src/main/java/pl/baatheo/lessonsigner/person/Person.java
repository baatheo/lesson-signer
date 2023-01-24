package pl.baatheo.lessonsigner.person;

import lombok.Getter;
import lombok.Setter;
import pl.baatheo.lessonsigner.internal.model.BaseEntity;
import pl.baatheo.lessonsigner.lesson.Lesson;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String index;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "person_lesson",
            joinColumns = @JoinColumn(name = "id_person"),
            inverseJoinColumns = @JoinColumn(name = "id_lesson"))
    private Set<Lesson> lessons;
}
