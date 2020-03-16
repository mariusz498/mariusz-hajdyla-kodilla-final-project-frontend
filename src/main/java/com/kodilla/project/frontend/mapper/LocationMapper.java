package com.kodilla.project.frontend.mapper;

import com.kodilla.project.frontend.domain.Location;
import com.kodilla.project.frontend.domain.LocationDto;
import java.lang.reflect.Parameter;
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
               locationDto.getOrdersTo()
       );
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
