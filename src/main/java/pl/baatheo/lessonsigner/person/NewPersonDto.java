package pl.baatheo.lessonsigner.person;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class NewPersonDto {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Size(min = 6, max = 6)
    private String index;

}
