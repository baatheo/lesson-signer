package pl.baatheo.lessonsigner.subject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository repository;
    private final SubjectMapper mapper;

    public void saveSubject(NewSubjectDTO newSubject) {
        repository.save(mapper.map(newSubject));
    }

    public List<Subject> findAll() {
        return repository.findAll();
    }
}
