package com.kodilla.project.frontend.views;

import com.kodilla.project.frontend.client.BackendClient;
import com.kodilla.project.frontend.countries.CountriesWithCodes;
import com.kodilla.project.frontend.domain.*;
import com.kodilla.project.frontend.mapper.LocationMapper;
import com.kodilla.project.frontend.mapper.OrderMapper;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Route(value = "company/main")
public class CompanyLoggedView extends VerticalLayout {

    @Autowired
    private Company company;

    @Autowired
    private BackendClient backendClient;

    @Autowired
    private CountriesWithCodes countriesWithCodes;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrdersList ordersList;

    @Autowired
    private Location origin;

    @Autowired
    private Location destination;

    @Autowired
    private LocationMapper locationMapper;


    public CompanyLoggedView() {
        company = VaadinSession.getCurrent().getAttribute(Company.class);
        ordersList = VaadinSession.getCurrent().getAttribute(OrdersList.class);
        add(headerLayout());
        Button createOrderButton = new Button("New order");
        add(createOrderButton);
        HorizontalLayout createOrderLayout = createOrderLayout();
        createOrderLayout.setVisible(false);
        add(createOrderLayout);
        createOrderButton.addClickListener(e -> createOrderLayout.setVisible(true));

        add(ordersGrid());
    }

    private HorizontalLayout headerLayout() {
        HorizontalLayout layout = new HorizontalLayout();
        Text welcomeText = new Text("You are logged in as supplier: " + company.getLogin());
        Button logoutButton = new Button("Log out");
        logoutButton.addClickListener(e -> {
            VaadinSession.getCurrent().setAttribute(Company.class, null);
            UI.getCurrent().navigate(MainView.class);
        });
        layout.add(welcomeText);
        layout.add(logoutButton);
        return layout;
    }

    private HorizontalLayout buttonsLayout() {
        HorizontalLayout layout = new HorizontalLayout();

/*        Button editOrderButton = new Button("Edit order");
        editOrderButton.addClickListener(e -> {
            ordersGrid().getSelectedItems();
        });
        layout.add(editOrderButton);*/
        return layout;
    }

    private HorizontalLayout createOrderLayout() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.add(originLocationLayout());
        layout.add(destinationLocationLayout());
        return layout;
    }

    private VerticalLayout originLocationLayout() {
        VerticalLayout layout = new VerticalLayout();
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
                Notification.show("Bad data. Check if country is chosen and city and address fields are not empty.");
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
                    origin = location;
                }
            }
        });
        layout.add(countriesCombo);
        layout.add(cityField);
        layout.add(locationField);
        layout.add(searchButton);
        layout.add(foundLocation);
        return layout;
    }

    private VerticalLayout destinationLocationLayout() {
        VerticalLayout layout = new VerticalLayout();
        Map<String, String> countriesCodes = new HashMap<>();
        countriesCodes = new CountriesWithCodes(countriesCodes).getCountriesMap();
        Set<String> countriesNames = new HashSet<>();
        for(Map.Entry<String, String> entry : countriesCodes.entrySet()) {
            countriesNames.add(entry.getValue());
        }
        ComboBox<String> countriesCombo = new ComboBox<>();
        countriesCombo.setLabel("Destination country");
        countriesCombo.setItems(countriesNames);
        TextField cityField = new TextField();
        cityField.setLabel("Destination city");
        TextField locationField = new TextField();
        locationField.setLabel("Destination address");
        TextArea foundLocation = new TextArea();
        foundLocation.setLabel("Found location:");
        foundLocation.setVisible(false);
        Button searchButton = new Button("Search");
        Map<String, String> finalCountriesCodes = countriesCodes;
        searchButton.addClickListener(e -> {
            if(cityField.isEmpty() || locationField.isEmpty() || countriesCombo.getValue().equals("Choose country")){
                Notification.show("Bad data. Check if country is chosen and city and address fields are not empty.");
            }
            else {
                String countryCode = finalCountriesCodes.get(countriesCombo.getValue());
                String city = cityField.getValue();
                String query = locationField.getValue();
                Location location = locationMapper.mapToLocation(backendClient.fetchLocation(countryCode, city, query));
                foundLocation.setVisible(true);
                if(location.getLabel().isEmpty()) {
                    foundLocation.setValue("Location not found.");
                }
                else {
                    foundLocation.setValue(location.getLabel());
                    destination = location;
                }
            }
        });
        layout.add(countriesCombo);
        layout.add(cityField);
        layout.add(locationField);
        layout.add(searchButton);
        return layout;
    }

    private Grid<Order> ordersGrid() {
        Grid<Order> grid = new Grid<>(Order.class);
        grid.setColumns("id", "description", "origin", "destination", "value", "currency", "status");
        grid.setSizeFull();
        grid.setDetailsVisibleOnClick(true);
        grid.setHeight("500");
        grid.setVerticalScrollingEnabled(true);
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        if(ordersList.getOrdersList().isEmpty()) {
            add(new Text("You have no orders yet."));
            grid.setVisible(false);
        }
        else {
            add(new Text("Your orders: "));
            grid.setItems(ordersList.getOrdersList());
        }
        return grid;
    }
}
