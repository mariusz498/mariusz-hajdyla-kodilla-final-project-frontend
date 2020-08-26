package com.kodilla.project.frontend.mapper;

import com.kodilla.project.frontend.domain.Location;
import com.kodilla.project.frontend.domain.LocationDto;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {


    public Location mapToLocation(LocationDto locationDto) {
        return new Location(
                locationDto.getId(),
                locationDto.getLabel(),
                locationDto.getLatitude(),
                locationDto.getLongitude(),
                locationDto.getOrdersFrom(),
                locationDto.getOrdersTo());
    }
    
    public LocationDto mapToLocationDto(Location location) {
        return new LocationDto(
                location.getId(),
                location.getLabel(),
                location.getLatitude(),
                location.getLongitude(),
                location.getOrdersFrom(),
                location.getOrdersTo());
    }
}
