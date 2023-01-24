package pl.baatheo.lessonsigner.person;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import pl.baatheo.lessonsigner.lesson.LessonService;
import pl.baatheo.lessonsigner.personlesson.PersonLesson;
import pl.baatheo.lessonsigner.personlesson.PersonLessonRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;
    private final PersonMapper mapper;
    private final LessonService lessonService;
    private final PersonLessonRepository personLessonRepository;

    public void save(NewPersonDto newPersonDto) {
        repository.save(mapper.map(newPersonDto));
    }

    public Person findPersonWithLesson(String index) {
        return repository.findAllByIndex(index)
                .orElseThrow(EntityNotFoundException::new);
    }

    public void signPerson(String index, long lessonId) {
        val person = repository.findAllByIndex(index).orElseThrow(EntityNotFoundException::new);
        val lesson = lessonService.findById(lessonId);
        val personLesson = new PersonLesson();
        personLesson.setPerson(person);
        personLesson.setLesson(lesson);
        personLessonRepository.save(personLesson);
    }

    @Transactional
    public void cancelSignLesson(String index, long lessonId) {
        personLessonRepository.deleteByLessonIdAndPersonIndex(lessonId, index);
    }
}
