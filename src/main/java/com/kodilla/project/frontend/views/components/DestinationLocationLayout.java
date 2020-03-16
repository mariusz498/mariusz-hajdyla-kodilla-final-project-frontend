package com.kodilla.project.frontend.views.components;

import com.kodilla.project.frontend.client.BackendClient;
import com.kodilla.project.frontend.countries.CountriesWithCodes;
import com.kodilla.project.frontend.domain.Location;
import com.kodilla.project.frontend.mapper.LocationMapper;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class DestinationLocationLayout extends VerticalLayout{

    @Autowired
    private LocationMapper locationMapper;

    @Autowired
    private BackendClient backendClient;

    @Autowired
    private Location destination;

    public DestinationLocationLayout() {
        CountriesWithCodes newCodes = new CountriesWithCodes();
        Map<String, String> countriesCodes = newCodes.fetchCodes();
        Set<String> countriesNames = new HashSet<>();
        for(Map.Entry<String, String> entry : countriesCodes.entrySet()) {
            countriesNames.add(entry.getKey());
        }
        ComboBox<String> countriesCombo = new ComboBox<>();
        countriesCombo.setLabel("Origin country");
        countriesCombo.setItems(countriesNames);
        TextField cityField = new TextField();
        cityField.setLabel("Origin city");
        TextField locationField = new TextField();
        locationField.setLabel("Origin address");
        TextArea foundLocation = new TextArea();
        foundLocation.setLabel("Found location:");
        foundLocation.setVisible(false);
        Button searchButton = new Button("Search");
        searchButton.addClickListener(e -> {
            if(cityField.isEmpty() || locationField.isEmpty() || countriesCombo.getValue().isEmpty()){
                Notification.show("Incomplete data. Check if country is chosen and city and address fields are not empty.");
            }
            else {
                String countryCode = countriesCodes.get(countriesCombo.getValue());
                String city = cityField.getValue();
                String query = locationField.getValue();
                Location location = locationMapper.mapToLocation(backendClient.fetchLocation(countryCode, city, query));
                foundLocation.setVisible(true);
                if(location == null) {
                    foundLocation.setValue("Location not found.");
                }
                else {
                    foundLocation.setValue(location.getLabel());
                    destination = location;
                }
            }
        });
        add(countriesCombo);
        add(cityField);
        add(locationField);
        add(searchButton);
        add(foundLocation);
    }
}