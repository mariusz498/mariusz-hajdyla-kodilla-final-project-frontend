package com.kodilla.project.frontend.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kodilla.project.frontend.domain.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.kodilla.project.frontend.mapper.JsonMapper;
import com.kodilla.project.frontend.mapper.OrderMapper;
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

    @Autowired
    private JsonMapper jsonMapper;

    @Autowired
    private OrderMapper orderMapper;

    public List<CompanyDto> getCompanies() {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/smart_shipping/companies").build().encode().toUri();
        try {
            CompanyDto[] response = restTemplate.getForObject(url, CompanyDto[].class);
            return Arrays.asList(ofNullable(response).orElse(new CompanyDto[0]));
        } catch (RestClientException e) {
            return new ArrayList<>();
        }
    }

    public CompanyDto getCompanyByLogin(String login) {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/smart_shipping/companies/login=" + login).build().encode().toUri();
            CompanyDto response = restTemplate.getForObject(url, CompanyDto.class);
            return ofNullable(response).orElse(new CompanyDto());
    }

    public boolean createCompany(Company company) throws JsonProcessingException {

            String url = "http://localhost:8081/smart_shipping/companies";
            try {
                HttpEntity httpEntity = jsonMapper.mapToJson(company);
                CompanyDto response = restTemplate.postForObject(url, httpEntity, CompanyDto.class);
                if (response.getLogin().equals(company.getLogin()) && response.getPasswordMD5().equals(company.getPasswordMD5())) {
                    return true;
                }
            } catch (RestClientException e) {
                System.out.println(e);
            }
            return false;
    }

    public DriverDto getDriverByLogin(String login) {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/smart_shipping/drivers/login=" + login).build().encode().toUri();
        DriverDto response = restTemplate.getForObject(url, DriverDto.class);
        return ofNullable(response).orElse(new DriverDto());
    }

    public boolean createDriver(Driver driver) throws JsonProcessingException {

        String url = "http://localhost:8081/smart_shipping/drivers";
        try {
            HttpEntity httpEntity = jsonMapper.mapToJson(driver);
            DriverDto response = restTemplate.postForObject(url, httpEntity, DriverDto.class);
            if (response.getLogin().equals(driver.getLogin()) && response.getPasswordMD5().equals(driver.getPasswordMD5())) {
                return true;
            }
        } catch (RestClientException e) {
            System.out.println(e);
        }
        return false;
    }

    public List<OrderDto> getOrdersByCompany(String login) {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/smart_shipping/orders/companyLogin=" + login).build().encode().toUri();
        try {
            OrderDto[] response = restTemplate.getForObject(url, OrderDto[].class);
            return Arrays.asList(ofNullable(response).orElse(new OrderDto[0]));
        } catch (RestClientException e) {
            return new ArrayList<>();
        }
    }

    public LocationDto fetchLocation(String countryCode, String city, String query) {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/smart_shipping/location")
                .queryParam("countryCode", countryCode)
                .queryParam("city", city)
                .queryParam("query", query)
                .build().encode().toUri();
        try {
            LocationDto response = restTemplate.getForObject(url, LocationDto.class);
            return (ofNullable(response).orElse(new LocationDto()));
        }
        catch (RestClientException e) {
        }
        return new LocationDto();
    }
}
