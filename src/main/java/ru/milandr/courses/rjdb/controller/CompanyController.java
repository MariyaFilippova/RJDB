package ru.milandr.courses.rjdb.controller;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.milandr.courses.rjdb.dtos.CompanyDto;

import ru.milandr.courses.rjdb.services.CompanyService;
import javax.validation.ValidationException;
import java.util.List;

@RestController
@RequestMapping("api/company")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/{companyId}")
    public CompanyDto getCompany(@PathVariable Long companyId) {
        return companyService.getCompany(companyId);
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCompany(@RequestBody CompanyDto companyDto) throws ValidationException {
        companyService.createCompany(companyDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CompanyDto>> getAll() {
        return ResponseEntity.ok(companyService.getAll());
    }


}