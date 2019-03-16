package ru.milandr.courses.rjdb.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import ru.milandr.courses.rjdb.entities.Resume;
import ru.milandr.courses.rjdb.entities.enums.Status;

import java.util.List;

public class VacancyDto {
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private long company_id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String vacancy;



    private short status;

    @Getter
    @Setter
    private List<ResumeDto> resumes;



    @Getter
    @Setter
    private long area_id;


    public VacancyDto(long id, String name, String vacancy, short status, long area_id, long company_id )
    {
        this.id = id;
        this.name = name;
        this.area_id = area_id;
        this.vacancy = vacancy;
        this.status = status;
        this.company_id = company_id;
    }

    @JsonIgnore
    public Status getStatus()
    {
        return Status.parse(this.status);
    }

    @JsonIgnore
    public void setStatus(Status orderStatus)
    {
        this.status= orderStatus.getValue();
    }

}
