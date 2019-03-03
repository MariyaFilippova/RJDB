package ru.milandr.courses.rjdb.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.milandr.courses.rjdb.entities.enums.Area;
import ru.milandr.courses.rjdb.entities.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "VACANCIES")
@ToString(exclude = "company")
public class Vacancy {

    @Id
    @Column(name = "id")
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vacancy_seq_gen")
    @SequenceGenerator(name = "vacancy_seq_gen", sequenceName = "vacancy_id_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "COMPANY_ID")
    @NotNull
    @Getter
    @Setter
    private Long companyId;

    @ManyToOne(fetch = FetchType.LAZY)
    // JoinColumn indicates that this entity is the owner of the relationship
    // (that is: the corresponding table has a column with a foreign key to the
    // referenced table), whereas the attribute mappedBy indicates that the
    // entity in this side is the inverse of the relationship
    @JoinColumn(name = "COMPANY_ID", insertable = false, updatable = false)
    @Getter
    @Setter
    private Company company;

    @Column(name = "NAME")
    @NotNull
    @Getter
    @Setter
    private String name;

    @Column(name = "VACANCY")
    @NotNull
    @Getter
    @Setter
    private String vacancy;

    @Column(name = "STATUS")
    private short status;

    public Status getStatus() {
        return Status.parse(this.status);
    }

    public void setStatus(Status status) {
        this.status = status.getValue();
    }

    @Column(name = "AREA")
    private short area;

    public Area getArea() {
        return Area.parse(this.area);
    }

    public void setArea(Area area) {
        this.area = area.getValue();
    }


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "RESUMES_VACANCIES",
            joinColumns = {@JoinColumn(name = "resume_id")},
            inverseJoinColumns = {@JoinColumn(name = "vacancy_id")})
    @Getter
    @Setter
    private List<Resume> resumes;
}
