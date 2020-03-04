package com.kodilla.project.frontend.views;

import com.kodilla.project.frontend.client.BackendClient;
import com.kodilla.project.frontend.domain.CompanyDto;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class MainView extends VerticalLayout {

    @Autowired
    private BackendClient backendClient;

    public MainView() {
        add(buildButtonsLayout());
    }

    private HorizontalLayout buildButtonsLayout() {
        HorizontalLayout buttonsLayout = new HorizontalLayout();
        Button companiesButton = new Button("For Companies");
        Button deliverersButton = new Button("For deliverers");
        Button trackingButton = new Button("Order tracking");
        buttonsLayout.add(companiesButton);
        companiesButton.addClickListener(e -> {
            UI.getCurrent().navigate(CompanyLoginView.class);
        });
        trackingButton.addClickListener(e -> {
            List<CompanyDto> companies;
            companies = backendClient.getCompanies();
            System.out.println(companies.toString());
        });
        buttonsLayout.add(deliverersButton);
        buttonsLayout.add(trackingButton);
        return buttonsLayout;
    }
}
