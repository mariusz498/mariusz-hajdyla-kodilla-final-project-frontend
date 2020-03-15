package com.kodilla.project.frontend.mapper;

import com.kodilla.project.frontend.domain.Location;
import com.kodilla.project.frontend.domain.LocationDto;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    public Location mapToLocation(LocationDto locationDto) {
       Location location = new Location(
               locationDto.getId(),
               locationDto.getLabel(),
               locationDto.getLattitude(),
               locationDto.getLongitude(),
               locationDto.getOrdersFrom(),
               locationDto.getOrdersTo()
       );
       return location;
    }
}
