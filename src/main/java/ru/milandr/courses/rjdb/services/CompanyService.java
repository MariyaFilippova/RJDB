package ru.milandr.courses.rjdb.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import ru.milandr.courses.rjdb.daos.CompanyDao;

import ru.milandr.courses.rjdb.dtos.CompanyDto;

import ru.milandr.courses.rjdb.entities.Company;

@Setter
@Getter
@Service

public class CompanyService

{
    private CompanyDao companyDao;
    public CompanyService(CompanyDao companyDao)
    {
        this.companyDao = getCompanyDao();
    }
    public CompanyDto getCompany (long companyId)
    {
        Company company= companyDao.findOne(companyId);
        return buildCompanyDtoFromCompany(company);
    }

    private CompanyDto buildCompanyDtoFromCompany(Company company)
    {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setEmail(company.getEmail());
        companyDto.setName(company.getName());
        companyDto.setPhoto(company.getPhoto());

        return companyDto;
    }


}

