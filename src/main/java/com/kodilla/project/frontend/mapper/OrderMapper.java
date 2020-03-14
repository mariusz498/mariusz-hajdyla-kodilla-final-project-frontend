package com.kodilla.project.frontend.mapper;

import com.kodilla.project.frontend.domain.Order;
import com.kodilla.project.frontend.domain.OrderDto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
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

    public List<Order> mapToOrdersList(List<OrderDto> orderDtos) {
        List<Order> orders = new ArrayList<>();
        for(OrderDto orderDto : orderDtos) {
            orders.add(mapToOrder(orderDto));
        }
        return orders;
    }
}
