package ru.milandr.courses.rjdb.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "USERS")
@ToString
public class Company {

    @Id
    @Column(name = "id")
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_id_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "EMAIL")
    @NotNull
    @Getter
    @Setter
    private String email;

    @Column(name = "NAME")
    @NotNull
    @Getter
    @Setter
    private String name;

    @Column(name = "PHOTO")
    @Getter
    @Setter
    private byte[] photo;


    @Column(name = "PASSWORD_HASH")
    @Getter
    @Setter
    private String passwordHash;

    @Column(name = "PASSWORD_SALT")
    @Getter
    @Setter
    private String passwordSalt;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    @Getter
    @Setter
    private List<Vacancy> vacancies;


}