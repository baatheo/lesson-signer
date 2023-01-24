package pl.baatheo.lessonsigner.subject;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    Subject map(NewSubjectDTO newSubjectDTO);
}
