package com.kodilla.project.frontend.mapper;

import com.kodilla.project.frontend.client.BackendClient;
import com.kodilla.project.frontend.domain.Company;
import com.kodilla.project.frontend.domain.CompanyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    BackendClient backendClient;

    public Company mapToCompany(final CompanyDto companyDto) {
        return new Company(
                companyDto.getId(),
                companyDto.getLogin(),
                companyDto.getPasswordMD5(),
                orderMapper.mapToOrdersList(backendClient.getOrdersByCompany(companyDto.getLogin())));
    }
}
