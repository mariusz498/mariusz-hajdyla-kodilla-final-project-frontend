package com.kodilla.project.frontend.views;

import com.kodilla.project.frontend.client.BackendClient;
import com.kodilla.project.frontend.countries.CountriesWithCodes;
import com.kodilla.project.frontend.domain.*;
import com.kodilla.project.frontend.mapper.LocationMapper;
import com.kodilla.project.frontend.mapper.OrderMapper;
import com.kodilla.project.frontend.views.components.CreateOrderLayout;
import com.kodilla.project.frontend.views.components.HeaderLayout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    private OrderRequestDto orderRequest;

    public CompanyLoggedView() {
        company = VaadinSession.getCurrent().getAttribute(Company.class);
        final Company finalCompany = company;
        ordersList = VaadinSession.getCurrent().getAttribute(OrdersList.class);
        HeaderLayout headerLayout = new HeaderLayout(company);
        CreateOrderLayout createOrderLayout = new CreateOrderLayout();
        Button createOrderButton = new Button("New order");
        createOrderButton.addClickListener(e -> createOrderLayout.setVisible(true));
        Grid<Order> ordersGrid = ordersGrid();
        Button sendOrderRequestButton = new Button("Create order");
        sendOrderRequestButton.addClickListener(e -> {
                List<Order> newList = ordersList.getOrdersList();
                company = finalCompany;
                newList.add(orderMapper.mapToOrder(backendClient.fetchOrderRequest(company, createOrderLayout)));
                ordersList.setOrdersList(newList);
                ordersGrid.setItems(ordersList.getOrdersList());
                });
        add(headerLayout);
        add(createOrderButton);
        add(createOrderLayout);
        createOrderLayout.add(sendOrderRequestButton);
        if(ordersList.getOrdersList().isEmpty()) {
            add(new Text("You have no orders yet"));
        }
        else {
            add(new Text("Your orders: "));
        }
        add(ordersGrid);
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
            grid.setVisible(false);
        }
        else {
            grid.setItems(ordersList.getOrdersList());
        }
        return grid;
    }
}
