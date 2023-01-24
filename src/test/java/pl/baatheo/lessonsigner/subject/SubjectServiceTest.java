package pl.baatheo.lessonsigner.subject;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {
        "classpath:database/cleanup_all.sql",
        "classpath:database/init_subject.sql"
})
public class SubjectServiceTest {

    @Autowired
    SubjectService service;

    @DisplayName("Find all")
    @Test
    public void findAll() {
        val subjects = service.findAll();
        assertEquals(3, subjects.size());
    }

    @DisplayName("save subject and find it")
    @Test
    public void saveAndFind() {
        val newSubject = new NewSubjectDTO();
        val name = "seminarium";
        newSubject.setName(name);
        newSubject.setOwner("bartek");

        service.saveSubject(newSubject);

        val anyMatch = service.findAll()
                .stream()
                .anyMatch(subject -> subject.getName().equals(name));
        assertTrue(anyMatch);
    }

}
