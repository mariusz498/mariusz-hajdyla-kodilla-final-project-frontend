package com.kodilla.project.frontend.mapper;

import com.kodilla.project.frontend.domain.Order;
import com.kodilla.project.frontend.domain.OrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public Order mapToOrder(OrderDto orderDto) {
        Order order = new Order(
                orderDto.getId(),
                orderDto.getDescription(),
                orderDto.getCompany(),
                orderDto.getOrigin(),
                orderDto.getDestination(),
                orderDto.getDriver(),
                orderDto.getValue(),
                orderDto.getCurrency(),
                orderDto.getStatus());
        return order;
    }
}
