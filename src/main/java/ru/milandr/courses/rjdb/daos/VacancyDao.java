package ru.milandr.courses.rjdb.daos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.milandr.courses.rjdb.entities.Vacancy;

import java.util.List;

@Repository
public interface VacancyDao extends CrudRepository<Vacancy, Long> {

    @Query("SELECT p FROM Vacancy p")
    List<Vacancy> findAllBy();
}

