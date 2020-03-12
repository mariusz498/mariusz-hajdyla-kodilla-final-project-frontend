package com.kodilla.project.frontend.mapper;

import com.kodilla.project.frontend.domain.Company;
import com.kodilla.project.frontend.domain.CompanyDto;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {
    public Company mapToCompany(final CompanyDto companyDto) {
        return new Company(
                companyDto.getId(),
                companyDto.getLogin(),
                companyDto.getPasswordMD5(),
                companyDto.getOrders());
    }
}
