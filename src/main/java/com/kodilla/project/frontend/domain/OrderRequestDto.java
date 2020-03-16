package com.kodilla.project.frontend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Component
public class OrderRequestDto {
    private Company company;
    private LocationDto origin;
    private LocationDto destination;
    private Map<String, Boolean> options;
    private String currency;
}
