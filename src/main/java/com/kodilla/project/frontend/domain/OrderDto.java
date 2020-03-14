package com.kodilla.project.frontend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("description")
    private String description;
    @JsonProperty("company")
    private Company company;
    @JsonProperty("origin")
    private Location origin;
    @JsonProperty("destination")
    private Location destination;
    @JsonProperty("driver")
    private Driver driver;
    @JsonProperty("value")
    private Double value;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("status")
    private String status;
}
