package com.kodilla.project.frontend.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kodilla.project.frontend.domain.Company;
import com.kodilla.project.frontend.domain.CompanyDto;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import static java.util.Optional.ofNullable;

@Component
public class BackendClient {

    @Autowired
    private Template restTemplate;

    public List<CompanyDto> getCompanies() {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/smart_shipping/companies").build().encode().toUri();
        try {
            CompanyDto[] response = restTemplate.getForObject(url, CompanyDto[].class);
            return Arrays.asList(ofNullable(response).orElse(new CompanyDto[0]));
        } catch (RestClientException e) {
            return new ArrayList<>();
        }
    }

    public boolean createCompany(Company company) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(company);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpEntity httpEntity = new HttpEntity(jsonString, httpHeaders);
        String url = "http://localhost:8081/smart_shipping/companies";
        try {
            HttpStatus response  = restTemplate.postForObject(url, httpEntity, null);
            //TODO change response type in front and backend
            if (response.is2xxSuccessful()) {
                return true;
            }
        } catch (RestClientException e) {
            System.out.println(e);
        }
        return false;
    }
}
