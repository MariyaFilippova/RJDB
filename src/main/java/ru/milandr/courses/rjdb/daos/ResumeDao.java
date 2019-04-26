package ru.milandr.courses.rjdb.daos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.milandr.courses.rjdb.entities.Resume;


import java.util.List;

@Repository
public interface ResumeDao extends CrudRepository<Resume, Long> {

    List<Resume> findByUserId(Long userId);
}
