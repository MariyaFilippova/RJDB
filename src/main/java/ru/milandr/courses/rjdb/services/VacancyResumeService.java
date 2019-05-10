package ru.milandr.courses.rjdb.services;

import org.springframework.stereotype.Service;
import ru.milandr.courses.rjdb.daos.VacancyResumeDao;

import ru.milandr.courses.rjdb.dtos.VacancyResumeDto;


import ru.milandr.courses.rjdb.entities.VacancyResume;



@Service
public class VacancyResumeService {


    private VacancyResumeDao vacancyResumeDao;


    public VacancyResumeService(VacancyResumeDao vacancyResumeDao) {
        this.vacancyResumeDao = vacancyResumeDao;
    }



    public VacancyResume createVacancyResume (VacancyResumeDto vacancyResumeDto) {
        VacancyResume vacancyResume = buildVacancyResume(vacancyResumeDto);
        vacancyResume.setDependency((short)1);
        vacancyResume.setVacancyId(1L);
        vacancyResume.setResumeId(305L);
        vacancyResumeDao.save(vacancyResume);
        return vacancyResume;
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



}
