package com.kodilla.project.frontend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("description")
    private String description;
    @JsonProperty("company")
    private String company;
    @JsonProperty("origin")
    private Long origin;
    @JsonProperty("destination")
    private Long destination;
    @JsonProperty("driver")
    private String driver;
    @JsonProperty("value")
    private Double value;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("status")
    private String status;
}
