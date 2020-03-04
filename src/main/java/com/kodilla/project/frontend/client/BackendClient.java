package com.kodilla.project.frontend.client;

import com.kodilla.project.frontend.domain.CompanyDto;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import static java.util.Optional.ofNullable;

@Component
public class BackendClient {

    @Autowired
    private Template restTemplate;

    public List<CompanyDto> getCompanies() {
        URI url = UriComponentsBuilder.fromPath("localhost:8081/smart_shipping/companies").build().encode().toUri();

        try {
            CompanyDto[] response = restTemplate.getForObject(url, CompanyDto[].class);
            return Arrays.asList(ofNullable(response).orElse(new CompanyDto[0]));
        } catch (RestClientException e) {
            return new ArrayList<>();
        }
    }
}
