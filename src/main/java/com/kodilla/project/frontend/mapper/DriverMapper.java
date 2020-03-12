package com.kodilla.project.frontend.mapper;

import com.kodilla.project.frontend.domain.Company;
import com.kodilla.project.frontend.domain.CompanyDto;
import com.kodilla.project.frontend.domain.Driver;
import com.kodilla.project.frontend.domain.DriverDto;
import org.springframework.stereotype.Component;

@Component
public class DriverMapper {
    public Driver mapToDriver(final DriverDto driverDto) {
        return new Driver(
                driverDto.getId(),
                driverDto.getLogin(),
                driverDto.getPasswordMD5(),
                driverDto.getOrders());
    }
    
}
