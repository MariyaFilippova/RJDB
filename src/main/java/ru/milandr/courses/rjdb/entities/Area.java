package ru.milandr.courses.rjdb.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "AREAS")
@ToString

public class Area {

    @Id
    @Column(name = "id")
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "area_seq_gen")
    @SequenceGenerator(name = "area_seq_gen", sequenceName = "area_id_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    @NotNull
    @Getter
    @Setter
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "area")
    @Getter
    @Setter
    private List<Resume> resumes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "area")
    @Getter
    @Setter
    private List<Vacancy> vacancies;




}
