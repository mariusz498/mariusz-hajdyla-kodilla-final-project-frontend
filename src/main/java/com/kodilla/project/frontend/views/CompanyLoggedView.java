package com.kodilla.project.frontend.views;

import com.kodilla.project.frontend.client.BackendClient;
import com.kodilla.project.frontend.domain.*;
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
import org.springframework.stereotype.Component;

@Route(value = "company/main")
@Component
public class CompanyLoggedView extends VerticalLayout {

    @Autowired
    Company company;

    @Autowired
    BackendClient backendClient;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrdersList ordersList;

    @Autowired
    CreateOrderLayout createOrderLayout;


    public CompanyLoggedView() {
        if (VaadinSession.getCurrent() != null) {
            company = VaadinSession.getCurrent().getAttribute(Company.class);
            ordersList = VaadinSession.getCurrent().getAttribute(OrdersList.class);
            final Company finalCompany = company;
            HeaderLayout headerLayout = new HeaderLayout(company);
            Button createOrderButton = new Button("New order");
            createOrderButton.addClickListener(e -> createOrderLayout.setVisible(true));
            Grid<Order> ordersGrid = ordersGrid();
            Button sendOrderRequestButton = new Button("Create order");
            sendOrderRequestButton.addClickListener(e -> {
                company = finalCompany;
                List<Order> newList = orderMapper.mapToOrdersList(backendClient.getOrdersByCompany(company.getLogin()));
                newList.add(orderMapper.mapToOrder(backendClient.fetchOrderRequest(company, createOrderLayout)));
                ordersGrid.setItems(newList);
            });
            add(headerLayout);
            add(createOrderButton);
            add(createOrderLayout);
            createOrderLayout.add(sendOrderRequestButton);
            if (ordersList.getOrdersList().isEmpty()) {
                add(new Text("You have no orders yet"));
            } else {
                add(new Text("Your orders: "));
            }
            add(ordersGrid);
        }
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
