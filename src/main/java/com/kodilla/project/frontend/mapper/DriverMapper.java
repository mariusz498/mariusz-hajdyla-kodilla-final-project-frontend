package com.kodilla.project.frontend.mapper;

import com.kodilla.project.frontend.domain.*;
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
