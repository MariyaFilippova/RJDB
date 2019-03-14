package ru.milandr.courses.rjdb.dtos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import ru.milandr.courses.rjdb.entities.enums.Status;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ResumeDto {

    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private long user_id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String resume;



    private short status;

    @Getter
    @Setter
    private long area_id;


    public ResumeDto(long id, String name, String resume, short status, long area_id, long user_id )
    {
        this.id = id;
        this.name = name;
        this.area_id = area_id;
        this.resume = resume;
        this.status = status;
        this.user_id = user_id;
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
