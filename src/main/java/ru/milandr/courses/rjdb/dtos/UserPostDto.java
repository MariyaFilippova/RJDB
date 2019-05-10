package ru.milandr.courses.rjdb.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserPostDto {

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String name;


    @Getter
    @Setter
    private String password;
}