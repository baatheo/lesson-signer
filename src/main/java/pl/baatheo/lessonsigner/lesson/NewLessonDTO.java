package pl.baatheo.lessonsigner.lesson;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NewLessonDTO {

    private Long id;
    private LocalDateTime startDate;
}
