package pl.baatheo.lessonsigner.person;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person map(NewPersonDto newPersonDto);
}
