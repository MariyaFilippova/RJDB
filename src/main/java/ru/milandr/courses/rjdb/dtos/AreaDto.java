package ru.milandr.courses.rjdb.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class AreaDto {
    @Getter
    @Setter
    private long area_id;

    @Getter
    @Setter
    private String name;

    public AreaDto(long area_id, String name) {
        this.area_id = area_id;
        this.name = name;
    }

}
