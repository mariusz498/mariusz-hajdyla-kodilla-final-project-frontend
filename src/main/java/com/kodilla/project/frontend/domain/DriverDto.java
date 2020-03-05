package com.kodilla.project.frontend.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DriverDto {
    private Long id;
    private String login;
    private String passwordMD5;
    private List<Order> orders;
}
