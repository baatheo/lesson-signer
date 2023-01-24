package pl.baatheo.lessonsigner.lesson;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import pl.baatheo.lessonsigner.subject.SubjectRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository repository;
    private final SubjectRepository subjectRepository;

    public List<Lesson> findAll() {
        return repository.findAll();
    }

    public void saveLesson(NewLessonDTO newLessonDTO) {
        val subject = subjectRepository.findById(newLessonDTO.getId())
                .orElseThrow(EntityNotFoundException::new);
        val lesson = new Lesson();
        lesson.setStartDate(newLessonDTO.getStartDate());
        lesson.setSubject(subject);
        repository.save(lesson);
    }

    public Lesson findById(long lessonId) {
        return repository.findById(lessonId).orElseThrow(EntityNotFoundException::new);
    }
}
