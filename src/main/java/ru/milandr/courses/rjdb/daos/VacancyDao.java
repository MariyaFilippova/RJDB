package ru.milandr.courses.rjdb.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.milandr.courses.rjdb.entities.Vacancy;

@Repository
public interface VacancyDao extends CrudRepository<Vacancy, Long> {
}
