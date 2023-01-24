package pl.baatheo.lessonsigner.person;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("person")
public class PersonController {

    private final PersonService service;

    @GetMapping
    public Person findPersonWithLessons(@RequestParam String index) {
        return service.findPersonWithLesson(index);
    }

    @PostMapping
    public void savePerson(@RequestBody @Valid NewPersonDto newPersonDto) {
        service.save(newPersonDto);
    }

    @PutMapping("sign")
    public void signPerson(@RequestParam String index,
                           @RequestParam long lessonId) {
        service.signPerson(index, lessonId);
    }

    @DeleteMapping("cancel")
    public void cancelSignLesson(@RequestParam String index,
                             @RequestParam long lessonId) {
        service.cancelSignLesson(index, lessonId);
    }

}
