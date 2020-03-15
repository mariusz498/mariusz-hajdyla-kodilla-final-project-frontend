package com.kodilla.project.frontend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private Long id;
    private String label;
    private Double lattitude;
    private Double longitude;
    private List<Order> ordersFrom;
    private List<Order> ordersTo;
}
