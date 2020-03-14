package com.kodilla.project.frontend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Order {

    private Long id;
    private String description;
    private Company company;
    private Location origin;
    private Location destination;
    private Driver driver;
    private Double value;
    private String currency;
    private String status;
}
