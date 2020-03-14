package com.kodilla.project.frontend.views;

import com.kodilla.project.frontend.client.BackendClient;
import com.kodilla.project.frontend.countries.CountriesWithCodes;
import com.kodilla.project.frontend.domain.Company;
import com.kodilla.project.frontend.domain.Location;
import com.kodilla.project.frontend.domain.Order;
import com.kodilla.project.frontend.domain.OrdersList;
import com.kodilla.project.frontend.mapper.OrderMapper;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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


    public CompanyLoggedView() {
        company = VaadinSession.getCurrent().getAttribute(Company.class);
        ordersList = VaadinSession.getCurrent().getAttribute(OrdersList.class);
        add(headerLayout());
        add(buttonsLayout());
        add(createOrderLayout());
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
        Button createOrderButton = new Button("New order");
        //TODO: add listeners
        Button editOrderButton = new Button("Edit order");
        //TODO: add listeners
        return layout;
    }

    private HorizontalLayout createOrderLayout() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setVisible(false);
        layout.add(locationLayout("Origin"));
        layout.add(locationLayout("Destination"));
        return layout;
    }

    private VerticalLayout locationLayout(String locationType) {
        VerticalLayout layout = new VerticalLayout();
        Map<String, String> countriesCodes = new HashMap<>();
        CountriesWithCodes countries = new CountriesWithCodes(countriesCodes);

        Set<String> countriesNames = new HashSet<>();
        for(Map.Entry<String, String> entry : countriesCodes.entrySet()) {
            countriesNames.add(entry.getValue());
        }
        ComboBox<String> countriesCombo = new ComboBox<>();
        countriesCombo.setLabel(locationType + " country");
        countriesCombo.setItems(countriesNames);
        TextField cityField = new TextField();
        cityField.setLabel(locationType + " city");
        TextField locationField = new TextField();
        locationField.setLabel(locationType + " address");
        layout.add(countriesCombo);
        layout.add(cityField);
        layout.add(locationField);
        return layout;
    }

    private Grid<Order> ordersGrid() {
        Grid<Order> grid = new Grid<>(Order.class);
        grid.setColumns("id", "description", "origin", "destination", "value", "currency", "status");
        grid.setSizeFull();
        grid.setDetailsVisibleOnClick(true);
        grid.setHeight("500");
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
