package pl.baatheo.lessonsigner.person;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {
        "classpath:database/cleanup_all.sql",
        "classpath:database/init_subject.sql",
        "classpath:database/init_lesson.sql",
        "classpath:database/init_person.sql",
        "classpath:database/init_person_lesson.sql"
})
public class PersonServiceTest {

    @Autowired
    PersonService personService;

    @DisplayName("Save new person")
    @Test
    public void save() {
        val newPerson = new NewPersonDto();
        val index = "987654";
        newPerson.setFirstName("bartek");
        newPerson.setLastName("pe");
        newPerson.setIndex(index);

        personService.save(newPerson);

        val foundPerson = personService.findPersonWithLesson(index);
        assertEquals(index, foundPerson.getIndex());
    }

    @DisplayName("Cancel sign lesson")
    @Test
    public void findPersonWithLesson() {
        val index = "123456";
        val id = 3;

        val personWithLesson = personService.findPersonWithLesson(index);
        assertTrue(personWithLesson.getLessons().stream().anyMatch(
                lesson -> lesson.getId() == id
        ));
    }

}


