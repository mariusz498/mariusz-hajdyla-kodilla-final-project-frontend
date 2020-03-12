package com.kodilla.project.frontend.domain;

import com.vaadin.flow.spring.annotation.UIScope;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@UIScope
public class Company {
        private Long id;
        private String login;
        private String passwordMD5;
        private List<Order> orders;
}
