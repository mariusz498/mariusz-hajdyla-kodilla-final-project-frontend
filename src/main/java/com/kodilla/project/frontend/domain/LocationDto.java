package com.kodilla.project.frontend.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("label")
    private String label;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("ordersFrom")
    private List<Long> ordersFrom;
    @JsonProperty("ordersTo")
    private List<Long> ordersTo;
}
