package ru.milandr.courses.rjdb.daos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.milandr.courses.rjdb.entities.Resume;
import ru.milandr.courses.rjdb.entities.VacancyResume;
import ru.milandr.courses.rjdb.entities.VacancyResumePK;


import java.util.List;

@Repository
public interface VacancyResumeDao extends CrudRepository<VacancyResume, Long> {


}
