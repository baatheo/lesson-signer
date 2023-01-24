package pl.baatheo.lessonsigner.personlesson;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonLessonRepository extends JpaRepository<PersonLesson, Long> {

    void deleteByLessonIdAndPersonIndex(long lessonId, String index);
}
