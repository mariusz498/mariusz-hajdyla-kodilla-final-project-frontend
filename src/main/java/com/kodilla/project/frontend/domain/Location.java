package com.kodilla.project.frontend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Location {
    private Long id;
    private String label;
    private Double latitude;
    private Double longitude;
    private List<Long> ordersFrom;
    private List<Long> ordersTo;
}
