package com.kodilla.project.frontend.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kodilla.project.frontend.domain.*;
import com.kodilla.project.frontend.mapper.LocationMapper;
import com.kodilla.project.frontend.views.components.CreateOrderLayout;
import java.net.URI;
import java.util.*;
import com.kodilla.project.frontend.mapper.JsonMapper;
import com.kodilla.project.frontend.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static java.util.Optional.ofNullable;

@Component
public class BackendClient {

    @Autowired
    JsonMapper jsonMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    LocationMapper locationMapper;

    public List<CompanyDto> getCompanies() {
        RestTemplate restTemplate = new RestTemplate();
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/smart_shipping/companies").build().encode().toUri();
        try {
            CompanyDto[] response = restTemplate.getForObject(url, CompanyDto[].class);
            return Arrays.asList(ofNullable(response).orElse(new CompanyDto[0]));
        } catch (RestClientException e) {
            return new ArrayList<>();
        }
    }

    public CompanyDto getCompanyByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/smart_shipping/companies/login=" + login).build().encode().toUri();
            CompanyDto response = restTemplate.getForObject(url, CompanyDto.class);
            return ofNullable(response).orElse(new CompanyDto());
    }

    public boolean createCompany(Company company) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8081/smart_shipping/companies";
            try {
                HttpEntity<String> httpEntity = jsonMapper.mapToJson(company);
                CompanyDto response = restTemplate.postForObject(url, httpEntity, CompanyDto.class);
                if (response != null && response.getLogin().equals(company.getLogin()) && response.getPasswordMD5().equals(company.getPasswordMD5())) {
                    return true;
                }
            } catch (RestClientException e) {
                System.out.println(e);
            }
            return false;
    }

    public void deleteCompany(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/smart_shipping/companies/" + id.toString()).build().encode().toUri();
        restTemplate.delete(url);
    }

    public DriverDto getDriverByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/smart_shipping/drivers/login=" + login).build().encode().toUri();
        DriverDto response = restTemplate.getForObject(url, DriverDto.class);
        return ofNullable(response).orElse(new DriverDto());
    }

    public boolean createDriver(Driver driver) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/smart_shipping/drivers";
        try {
            HttpEntity<String> httpEntity = jsonMapper.mapToJson(driver);
            DriverDto response = restTemplate.postForObject(url, httpEntity, DriverDto.class);
            if (response != null && response.getLogin().equals(driver.getLogin()) && response.getPasswordMD5().equals(driver.getPasswordMD5())) {
                return true;
            }
        } catch (RestClientException e) {
            System.out.println(e);
        }
        return false;
    }

    public List<OrderDto> getOrdersByCompany(String login) {
        RestTemplate restTemplate = new RestTemplate();
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/smart_shipping/orders/companyLogin=" + login).build().encode().toUri();
        try {
            OrderDto[] response = restTemplate.getForObject(url, OrderDto[].class);
            return Arrays.asList(ofNullable(response).orElse(new OrderDto[0]));
        } catch (RestClientException e) {
            return new ArrayList<>();
        }
    }

    public LocationDto fetchLocation(String countryCode, String city, String query) {
        RestTemplate restTemplate = new RestTemplate();
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/smart_shipping/location")
                .queryParam("code", countryCode)
                .queryParam("city", city)
                .queryParam("query", query)
                .build().encode().toUri();
            return restTemplate.getForObject(url, LocationDto.class);
    }

    public OrderDto fetchOrderRequest(Company company, CreateOrderLayout layout) {
        LocationDto origin = locationMapper.mapToLocationDto(layout.getOriginLocationLayout().getOrigin());
        LocationDto destination = locationMapper.mapToLocationDto(layout.getDestinationLocationLayout().getDestination());
        Boolean ADR = layout.getOrderOptions().getADR().getValue();
        Boolean express = layout.getOrderOptions().getExpress().getValue();
        Boolean fragile = layout.getOrderOptions().getFragile().getValue();
        Map<String, Boolean> options = new HashMap<>();
        options.put("ADR", ADR);
        options.put("Express", express);
        options.put("Fragile", fragile);
        String currency = layout.getCurrencyCombo().getValue();
        OrderRequestDto orderRequestDto = new OrderRequestDto(company.getLogin(), origin, destination, options, currency);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/smart_shipping/orders";
            try {
                HttpEntity<String> httpEntity = jsonMapper.mapToJson(orderRequestDto);
                OrderDto response = restTemplate.postForObject(url, httpEntity, OrderDto.class);
                assert response != null;
                if (response.getOrigin().equals(orderRequestDto.getOrigin().getId())
                        && response.getDestination().equals(orderRequestDto.getDestination().getId())
                        && response.getCurrency().equals(orderRequestDto.getCurrency())) {
                   return response;
                }
            } catch (RestClientException | JsonProcessingException e) {
                System.out.println(e);
            }
            return new OrderDto();
    }

    public LocationDto getLocationById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/smart_shipping/locations/id=" + id.toString()).build().encode().toUri();
        LocationDto response = restTemplate.getForObject(url, LocationDto.class);
        return ofNullable(response).orElse(new LocationDto());
    }

    public OrderDto getOrderById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/smart_shipping/orders/" + id.toString()).build().encode().toUri();
        OrderDto response = restTemplate.getForObject(url, OrderDto.class);
        return ofNullable(response).orElse(new OrderDto());
    }
}
