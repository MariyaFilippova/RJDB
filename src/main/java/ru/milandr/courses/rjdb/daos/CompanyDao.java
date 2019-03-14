package ru.milandr.courses.rjdb.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.milandr.courses.rjdb.entities.Company;
@Repository
public interface CompanyDao extends CrudRepository<Company, Long> {
}
