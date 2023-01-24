package pl.baatheo.lessonsigner.lesson;

import lombok.Getter;
import lombok.Setter;
import pl.baatheo.lessonsigner.internal.model.BaseEntity;
import pl.baatheo.lessonsigner.subject.Subject;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Lesson extends BaseEntity {

    private LocalDateTime startDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_subject", nullable = false)
    private Subject subject;
}
