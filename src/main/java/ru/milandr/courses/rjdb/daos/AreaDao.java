package ru.milandr.courses.rjdb.daos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.milandr.courses.rjdb.entities.Area;


import java.util.List;

@Repository
public interface AreaDao extends CrudRepository<Area, Long> {
    @Query("SELECT p FROM Area p")
    List<Area> findAllBy();
}
