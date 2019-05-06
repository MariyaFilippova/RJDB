package ru.milandr.courses.rjdb.controller;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.milandr.courses.rjdb.dtos.VacancyDto;
import ru.milandr.courses.rjdb.dtos.VacancyResumeDto;
import ru.milandr.courses.rjdb.entities.VacancyResume;
import ru.milandr.courses.rjdb.services.VacancyResumeService;
import ru.milandr.courses.rjdb.services.VacancyService;
import javax.validation.ValidationException;
import java.util.List;

@RestController
@RequestMapping("vacancy_resume")
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
