package ru.milandr.courses.rjdb.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class VacancyResumePK implements Serializable {

    @Getter
    @Setter
    private Long vacancyId;

    @Getter
    @Setter
    private Long resumeId;

    public VacancyResumePK() {
    }

    public VacancyResumePK(Long vacancyId, Long resumeId) {
        this.vacancyId = vacancyId;
        this.resumeId = resumeId;
    }
}