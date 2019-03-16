package ru.milandr.courses.rjdb.services;

import org.springframework.stereotype.Service;
import ru.milandr.courses.rjdb.daos.VacancyDao;
import ru.milandr.courses.rjdb.dtos.VacancyDto;
import ru.milandr.courses.rjdb.entities.Vacancy;

@Service
public class VacancyService {

    private VacancyDao vacancyDao;

    public VacancyService(VacancyDao vacancyDao) {
        this.vacancyDao = vacancyDao;

    }

    public VacancyDto getVacancy(long vacancyId) {
        Vacancy vacancy = vacancyDao.findOne(vacancyId);

        return buildVacancyDtoFromVacancy(vacancy);
    }

    public Vacancy createVacancy(VacancyDto vacancyDto) {
        Vacancy vacancy = buildVacancyFromVacancyDto(vacancyDto);
        vacancyDao.save(vacancy);
        return vacancy;
    }


    private Vacancy buildVacancyFromVacancyDto(VacancyDto vacancyDto) {
        Vacancy vacancy = new Vacancy();
        vacancy.setId(vacancyDto.getId());
        vacancy.setAreaId(vacancyDto.getArea_id());
        vacancy.setStatus(vacancyDto.getStatus());
        vacancy.setCompanyId(vacancyDto.getCompany_id());
        vacancy.setVacancy(vacancyDto.getVacancy());
        return vacancy;

    }


    private VacancyDto buildVacancyDtoFromVacancy(Vacancy vacancy) {
        VacancyDto vacancyDto = new VacancyDto();
        vacancyDto.setId(vacancy.getId());
        vacancyDto.setCompany_id(vacancy.getCompanyId());
        vacancyDto.setVacancy(vacancy.getVacancy());
        vacancyDto.setArea_id(vacancy.getAreaId());
        vacancyDto.setStatus(vacancy.getStatus());
        return vacancyDto;


    }
}
