package ru.milandr.courses.rjdb.services;

import org.springframework.stereotype.Service;
import ru.milandr.courses.rjdb.daos.VacancyDao;
import ru.milandr.courses.rjdb.daos.VacancyResumeDao;

import ru.milandr.courses.rjdb.dtos.VacancyDto;
import ru.milandr.courses.rjdb.dtos.VacancyResumeDto;

import ru.milandr.courses.rjdb.entities.Vacancy;
import ru.milandr.courses.rjdb.entities.VacancyResume;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class VacancyService {

    private VacancyDao vacancyDao;
    private VacancyResumeDao vacancyResumeDao;


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
    public VacancyResume createVacancyResume (VacancyResumeDto vacancyResumeDto) {
        VacancyResume vacancyResume = new VacancyResume();
        vacancyResume.setDependency((short)1);
        vacancyResume.setVacancyId(1L);
        vacancyResume.setResumeId(vacancyResumeDto.getResume_id());
        vacancyResumeDao.save(vacancyResume);
        return vacancyResume;
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
    private VacancyResumeDto buildVacancyResumeDto(VacancyResume vacancyResume) {

        VacancyResumeDto vacancyResumeDto = new VacancyResumeDto(
                vacancyResume.getVacancyId(),
                vacancyResume.getResumeId(),
                vacancyResume.getDependency());


        return vacancyResumeDto;
    }
    private VacancyResume buildVacancyResume(VacancyResumeDto vacancyResumeDto) {

        VacancyResume vacancyResume = new VacancyResume(
                        vacancyResumeDto.getVacancy_id(),
                        vacancyResumeDto.getResume_id(),
                        vacancyResumeDto.getDependency());
        return vacancyResume;
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
