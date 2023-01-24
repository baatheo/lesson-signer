package pl.baatheo.lessonsigner.lesson;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("lesson")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService service;

    @GetMapping
    public List<Lesson> findAll(){
        return service.findAll();
    }

    @PostMapping
    public void saveLesson(@RequestBody @Valid NewLessonDTO newLessonDTO){
        service.saveLesson(newLessonDTO);
    }
}
