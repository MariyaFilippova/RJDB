package ru.milandr.courses.rjdb.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
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

}
