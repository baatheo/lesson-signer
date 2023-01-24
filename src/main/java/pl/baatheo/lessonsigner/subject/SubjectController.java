package pl.baatheo.lessonsigner.subject;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSubject(@RequestBody NewSubjectDTO subject) {
        service.saveSubject(subject);
    }

    @GetMapping
    public List<Subject> findAll() {
        return service.findAll();
    }

}
