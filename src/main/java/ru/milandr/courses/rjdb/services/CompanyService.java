package ru.milandr.courses.rjdb.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import ru.milandr.courses.rjdb.daos.CompanyDao;

import ru.milandr.courses.rjdb.dtos.CompanyDto;

import ru.milandr.courses.rjdb.dtos.VacancyDto;
import ru.milandr.courses.rjdb.entities.Company;
import ru.milandr.courses.rjdb.entities.Vacancy;


import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@Service

public class CompanyService {
    private CompanyDao companyDao;

    public CompanyService(CompanyDao companyDao) {
        this.companyDao = getCompanyDao();
    }

    public CompanyDto getCompany(long companyId) {
        Company company = companyDao.findOne(companyId);
        return buildCompanyDtoFromCompany(company);
    }

    public Company createCompany(CompanyDto companyDto) {
        Company company = buildCompanyFromCompanyDto(companyDto);
        companyDao.save(company);
        return company;
    }

    private Company buildCompanyFromCompanyDto(CompanyDto companyDto) {
        Company company = new Company();
        company.setName(companyDto.getName());
        company.setEmail(companyDto.getEmail());
        company.setPhoto(company.getPhoto());
        return company;
    }

    private CompanyDto buildCompanyDtoFromCompany(Company company) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setEmail(company.getEmail());
        companyDto.setName(company.getName());
        companyDto.setPhoto(company.getPhoto());
        companyDto.setVacancies(buildVacancyDtoListFromVacancyList(company.getVacancies()));
        return companyDto;
    }


    private List<VacancyDto> buildVacancyDtoListFromVacancyList(List<Vacancy> vacancies) {
        return vacancies.stream()
                .map(vacancy -> new VacancyDto(vacancy.getId(), vacancy.getName(), vacancy.getVacancy(), vacancy.getStatus().getValue(), vacancy.getAreaId(), vacancy.getCompanyId()))
                .collect(Collectors.toList());
    }

}

