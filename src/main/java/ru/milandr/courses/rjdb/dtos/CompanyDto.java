package ru.milandr.courses.rjdb.dtos;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

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



    public CompanyDto(Long id, String email, String name, byte[] photo, String phone_number) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.photo = photo;
    }
}
