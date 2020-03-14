package com.kodilla.project.frontend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Getter
@Setter
public class OrdersList {
    private List<Order> ordersList = new ArrayList<>();
}
