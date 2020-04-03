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


    public Location mapToLocation(LocationDto locationDto) {
       Location location = new Location(
               locationDto.getId(),
               locationDto.getLabel(),
               locationDto.getLatitude(),
               locationDto.getLongitude(),
               locationDto.getOrdersFrom(),
               locationDto.getOrdersTo());
       return location;
    }
    
    public LocationDto mapToLocationDto(Location location) {
        LocationDto locationDto = new LocationDto(
                location.getId(),
                location.getLabel(),
                location.getLatitude(),
                location.getLongitude(),
                location.getOrdersFrom(),
                location.getOrdersTo());
        return locationDto;
    }
}
