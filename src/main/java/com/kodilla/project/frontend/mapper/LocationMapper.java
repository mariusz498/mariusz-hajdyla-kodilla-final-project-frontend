package com.kodilla.project.frontend.mapper;

import com.kodilla.project.frontend.client.BackendClient;
import com.kodilla.project.frontend.domain.Location;
import com.kodilla.project.frontend.domain.LocationDto;
import com.kodilla.project.frontend.domain.Order;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    @Autowired
    private BackendClient backendClient;

    @Autowired
    private OrderMapper orderMapper;

    public Location mapToLocation(LocationDto locationDto) {
        List<Order> ordersFrom = new ArrayList<>();
        for(Long id : locationDto.getOrdersFrom()) {
            ordersFrom.add(orderMapper.mapToOrder(backendClient.getOrderById(id)));
        }
        List<Order> ordersTo = new ArrayList<>();
        for(Long id : locationDto.getOrdersTo()) {
            ordersTo.add(orderMapper.mapToOrder(backendClient.getOrderById(id)));
        }
       Location location = new Location(
               locationDto.getId(),
               locationDto.getLabel(),
               locationDto.getLatitude(),
               locationDto.getLongitude(),
               ordersFrom,
               ordersTo);
       return location;
    }
    
    public LocationDto mapToLocationDto(Location location) {
        List<Long> orders = new ArrayList<>();
        for(Order order : location.getOrdersFrom()) {
            orders.add(order.getId());
        }
        List<Long> ordersTo = new ArrayList<>();
        for(Order order : location.getOrdersTo()) {
            orders.add(order.getId());
        }
        LocationDto locationDto = new LocationDto(
                location.getId(),
                location.getLabel(),
                location.getLatitude(),
                location.getLongitude(),
                orders,
                ordersTo);
        return locationDto;
    }
}
