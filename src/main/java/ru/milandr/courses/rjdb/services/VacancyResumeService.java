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
        VacancyResume vacancyResume = new VacancyResume();
        vacancyResume.setDependency((short)1);
        vacancyResume.setVacancyId(vacancyResumeDto.getVacancy_id());
        vacancyResume.setResumeId(vacancyResumeDto.getResume_id());
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
