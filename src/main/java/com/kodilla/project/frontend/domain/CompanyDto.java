package com.kodilla.project.frontend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CompanyDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("login")
    private String login;
    @JsonProperty("passwordMD5")
    private String passwordMD5;
    @JsonProperty("orders")
    private List<Long> orders;
}
