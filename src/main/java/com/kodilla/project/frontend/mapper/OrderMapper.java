package com.kodilla.project.frontend.mapper;

import com.kodilla.project.frontend.client.BackendClient;
import com.kodilla.project.frontend.domain.Order;
import com.kodilla.project.frontend.domain.OrderDto;
import java.util.Optional;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
public class OrderMapper {

    @Autowired
    BackendClient backendClient;

    @Autowired
    CompanyMapper companyMapper;

    @Autowired
    LocationMapper locationMapper;

    @Autowired
    DriverMapper driverMapper;



    public Order mapToOrder(OrderDto orderDto) {
        return new Order(
                orderDto.getId(),
                orderDto.getDescription(),
                orderDto.getCompany(),
                locationMapper.mapToLocation(backendClient.getLocationById(orderDto.getOrigin())).getLabel(),
                locationMapper.mapToLocation(backendClient.getLocationById(orderDto.getDestination())).getLabel(),
                Optional.ofNullable(orderDto.getDriver()).orElse(""),
                orderDto.getValue(),
                orderDto.getCurrency(),
                orderDto.getStatus());
    }

    public List<Order> mapToOrdersList(List<OrderDto> orderDtos) {
        List<Order> orders = new ArrayList<>();
        for(OrderDto orderDto : orderDtos) {
            orders.add(mapToOrder(orderDto));
        }
        return orders;
    }
}
