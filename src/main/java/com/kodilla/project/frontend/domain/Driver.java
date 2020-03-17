package com.kodilla.project.frontend.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Driver extends User {
    private Long id;
    private String login;
    private String passwordMD5;
    private List<Long> orders;
}
