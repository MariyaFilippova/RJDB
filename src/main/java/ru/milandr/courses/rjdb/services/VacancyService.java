package ru.milandr.courses.rjdb.services;

import org.springframework.stereotype.Service;
import ru.milandr.courses.rjdb.daos.VacancyDao;
import ru.milandr.courses.rjdb.dtos.VacancyDto;
import ru.milandr.courses.rjdb.entities.Vacancy;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<VacancyDto> getAll() {
        return vacancyDao.findAllBy().stream()
                .map(this::buildVacancyDtoFromVacancy)
                .collect(Collectors.toList());
    }


   private Vacancy buildVacancyFromVacancyDto(VacancyDto vacancyDto) {
        Vacancy vacancy = new Vacancy();
        vacancy.setAreaId(vacancyDto.getArea_id());
        vacancy.setStatus(vacancyDto.getStatus());
        vacancy.setCompanyId(vacancyDto.getCompany_id());
        vacancy.setVacancy(vacancyDto.getVacancy());
        vacancy.setName(vacancyDto.getName());
        return vacancy;

    }


    private VacancyDto buildVacancyDtoFromVacancy(Vacancy vacancy) {
        VacancyDto vacancyDto = new VacancyDto();
        vacancyDto.setId(vacancy.getId());
        vacancyDto.setName(vacancy.getName());
        vacancyDto.setCompany_id(vacancy.getCompanyId());
        vacancyDto.setVacancy(vacancy.getVacancy());
        vacancyDto.setArea_id(vacancy.getAreaId());
        vacancyDto.setStatus(vacancy.getStatus());
        return vacancyDto;


    }
}
