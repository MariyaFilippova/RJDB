package ru.milandr.courses.rjdb.daos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.milandr.courses.rjdb.entities.Company;


import java.util.List;

@Repository
public interface CompanyDao extends CrudRepository<Company, Long> {
    @Query("SELECT p FROM Company p")
    List<Company> findAllBy();
}
