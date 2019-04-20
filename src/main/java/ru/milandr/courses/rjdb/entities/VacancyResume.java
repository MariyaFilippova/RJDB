package ru.milandr.courses.rjdb.entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "ORDERS_GOODS")
@IdClass(VacancyResumePK.class)
@NoArgsConstructor
@EqualsAndHashCode
@ToString(exclude = {"vacancy", "resume"})
public class VacancyResume {
    @Id
    @Column(name = "VACANCY_ID")
    @Getter
    @Setter
    private Long vacancyId;

    @Id
    @Column(name = "RESUME_ID")
    @Getter
    @Setter
    private Long resumeId;

    @Column(name = "DEPENDENCY")
    @Getter
    @Setter
    private short dependency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VACANCY_ID", insertable = false, updatable = false)
    @Getter
    @Setter
    private Vacancy vacancy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESUME_ID", insertable = false, updatable = false)
    @Getter
    @Setter
    private Resume resume;

    public VacancyResume(Long vacancyId, Long resumeId, short dependency) {
        this.vacancyId = vacancyId;
        this.resumeId = resumeId;
        this.dependency = dependency;
    }
}
