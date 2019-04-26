package ru.milandr.courses.rjdb.controller;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.milandr.courses.rjdb.dtos.VacancyDto;
import ru.milandr.courses.rjdb.services.VacancyService;
import javax.validation.ValidationException;
import java.util.List;

@RestController
@RequestMapping("vacancy")
public class VacancyController {

    private VacancyService vacancyService;

    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VacancyDto>> getAll() {
        return ResponseEntity.ok(vacancyService.getAll());
    }

    @GetMapping("/{vacancyId}")
    public VacancyDto getVacancy(@PathVariable Long vacancyId) {
        return vacancyService.getVacancy(vacancyId);
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createVacancy(@RequestBody VacancyDto vacancyDto) throws ValidationException {
        vacancyService.createVacancy(vacancyDto);


    }
}
