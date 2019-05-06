package ru.milandr.courses.rjdb.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import ru.milandr.courses.rjdb.entities.enums.Status;

import javax.persistence.Column;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class VacancyResumeDto {
    @Getter
    @Setter
    private long vacancy_id;

    @Getter
    @Setter
    private long resume_id;

    @Getter
    @Setter
    private short dependency;


    public VacancyResumeDto(Long resume_id, Long vacancy_id, short dependency) {
        this.resume_id = resume_id;
        this.vacancy_id = vacancy_id;
        this.dependency = dependency;
    }

}
