package com.kodilla.project.frontend.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LocationDto {
    private Long id;
    private String name;
    private Double lattitude;
    private Double longitude;
    private List<Order> ordersFrom;
    private List<Order> ordersTo;
}
