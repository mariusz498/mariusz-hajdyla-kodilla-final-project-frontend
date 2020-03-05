package com.kodilla.project.frontend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {
        @JsonProperty("login")
        private String login;
        @JsonProperty("passwordMD5")
        private String passwordMD5;
        @JsonProperty("orders")
        private List<Order> orders;
}
