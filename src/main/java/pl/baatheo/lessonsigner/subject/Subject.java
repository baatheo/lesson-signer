package pl.baatheo.lessonsigner.subject;

import lombok.Getter;
import lombok.Setter;
import pl.baatheo.lessonsigner.internal.model.BaseEntity;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Subject extends BaseEntity {
    private String name;
    private String owner;
}
