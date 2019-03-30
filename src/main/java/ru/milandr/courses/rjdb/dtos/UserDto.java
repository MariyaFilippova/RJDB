package ru.milandr.courses.rjdb.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class UserDto {
    @Getter
    @Setter
    private Long id;

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
    private String mobile_phone;

    @Getter
    @Setter
    private List<ResumeDto> resumes;


    public UserDto(Long id, String email, String name, byte[] photo, String mobile_phone, List<ResumeDto> resumes) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.photo = photo;
        this.mobile_phone = mobile_phone;
        this.resumes = resumes;
    }
}
