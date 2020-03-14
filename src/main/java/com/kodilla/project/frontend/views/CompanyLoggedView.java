package com.kodilla.project.frontend.views;

import com.kodilla.project.frontend.client.BackendClient;
import com.kodilla.project.frontend.domain.Company;
import com.kodilla.project.frontend.domain.Order;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Set;

@Route(value = "company/main")
@PageTitle("CompanyView")
public class CompanyLoggedView extends VerticalLayout {

    @Autowired
    private Company company;

    @Autowired
    private BackendClient backendClient;

    private Set<Order> orders;

    public CompanyLoggedView() {
        company = VaadinSession.getCurrent().getAttribute(Company.class);
        orders = backendClient.getOrdersByCompany(company.getLogin());
        add(headerLayout());
        if(orders.size() != 0) {
            add(new Text("Your orders: "));
            add(ordersGrid());
        }
        else {
            add(new Text("You have no orders yet"));
        }
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

        Button editOrderButton = new Button("Edit order");

        return layout;
    }

    private HorizontalLayout createOrderLayout() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setVisible(false);
        TextField originField = new TextField();
        originField.setLabel("Origin address");
        TextField destinationField = new TextField();
        destinationField.setLabel("Destination address");
        return layout;
    }

    private Grid<Order> ordersGrid() {
        Grid<Order> grid = new Grid<>(Order.class);
        grid.setColumns("id", "description", "origin", "destination", "status");
        grid.setSizeFull();
        grid.setItems(orders);
        grid.setDetailsVisibleOnClick(true);
        return grid;
    }
}
