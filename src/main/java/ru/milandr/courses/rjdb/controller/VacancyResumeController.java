package ru.milandr.courses.rjdb.controller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.milandr.courses.rjdb.dtos.VacancyResumeDto;
import ru.milandr.courses.rjdb.services.VacancyResumeService;

import javax.validation.ValidationException;

@RestController
@RequestMapping("api/vacancy_resume")
public class VacancyResumeController {

    private VacancyResumeService vacancyResumeService;

    public VacancyResumeController(VacancyResumeService vacancyResumeService) {
        this.vacancyResumeService = vacancyResumeService;
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createVacancyResume(@RequestBody VacancyResumeDto vacancyResumeDto) throws ValidationException {
        vacancyResumeService.createVacancyResume(vacancyResumeDto);

    }
}
