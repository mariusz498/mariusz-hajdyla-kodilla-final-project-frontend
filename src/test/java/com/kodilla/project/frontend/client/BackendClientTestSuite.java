package com.kodilla.project.frontend.client;

import com.kodilla.project.frontend.domain.LocationDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class BackendClientTestSuite {

        @Autowired
        private BackendClient backendClient;

        @Test
        public void fetchLocationTest() {
            //Given
            String countryName = "Polska";
            String countryCode = "POL";
            String city = "Kraków";
            String query = "Myśliwska 40A";
            //When
            LocationDto locationDto = backendClient.fetchLocation(countryName, countryCode, city, query);
            System.out.println(locationDto.getLabel());
        }
    }
