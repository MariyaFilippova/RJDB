package ru.milandr.courses.rjdb.controller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.milandr.courses.rjdb.dtos.VacancyDto;
import ru.milandr.courses.rjdb.services.VacancyService;
import javax.validation.ValidationException;

@RestController
@RequestMapping("vacancy")
public class VacancyController
{

    private VacancyService vacancyService;

    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @GetMapping("/{vacancyId}")
    public VacancyDto getVacancy(@PathVariable Long vacancyId) {
        return vacancyService.getVacancy(vacancyId);
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody VacancyDto vacancyDto) throws ValidationException {
        vacancyService.createVacancy(vacancyDto);
    }

}

