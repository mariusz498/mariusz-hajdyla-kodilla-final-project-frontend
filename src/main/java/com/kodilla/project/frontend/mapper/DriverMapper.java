package com.kodilla.project.frontend.mapper;

import com.kodilla.project.frontend.client.BackendClient;
import com.kodilla.project.frontend.domain.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DriverMapper {

    @Autowired
    private BackendClient backendClient;

    @Autowired
    private OrderMapper orderMapper;

    public Driver mapToDriver(final DriverDto driverDto) {
        List<Order> orders = new ArrayList<>();
        for(Long id : driverDto.getOrders()) {
            orders.add(orderMapper.mapToOrder(backendClient.getOrderById(id)));
        }
        return new Driver(
                driverDto.getId(),
                driverDto.getLogin(),
                driverDto.getPasswordMD5(),
                orders);
    }
    
}
