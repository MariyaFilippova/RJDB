package ru.milandr.courses.rjdb.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

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

    public UserDto(Long id, String email, String name, byte[] photo, String mobile_phone) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.photo = photo;
        this.mobile_phone = mobile_phone;
    }
}
