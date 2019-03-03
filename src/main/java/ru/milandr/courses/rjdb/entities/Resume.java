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
@Table(name = "RESUMES")
@ToString(exclude = "user")
public class Resume {

    @Id
    @Column(name = "id")
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resume_seq_gen")
    @SequenceGenerator(name = "resume_seq_gen", sequenceName = "resume_id_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "USER_ID")
    @NotNull
    @Getter
    @Setter
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    // JoinColumn indicates that this entity is the owner of the relationship
    // (that is: the corresponding table has a column with a foreign key to the
    // referenced table), whereas the attribute mappedBy indicates that the
    // entity in this side is the inverse of the relationship
    @JoinColumn(name = "USER_ID", insertable = false, updatable = false)
    @Getter
    @Setter
    private User user;

    @Column(name = "NAME")
    @NotNull
    @Getter
    @Setter
    private String name;

    @Column(name = "RESUME")
    @NotNull
    @Getter
    @Setter
    private String resume;

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
            joinColumns = {@JoinColumn(name = "vacancy_id")},
            inverseJoinColumns = {@JoinColumn(name = "resume_id")})
    @Getter
    @Setter
    private List<Vacancy> vacancies;
}
