package ru.milandr.courses.rjdb.dtos;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import ru.milandr.courses.rjdb.entities.Vacancy;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class CompanyDto {
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private byte[] photo;

    @Getter
    @Setter
    private List<VacancyDto> vacancies;



    public CompanyDto(Long id, String email, String name, byte[] photo, List<VacancyDto> vacancies) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.photo = photo;
        this.vacancies = vacancies;
    }
}
