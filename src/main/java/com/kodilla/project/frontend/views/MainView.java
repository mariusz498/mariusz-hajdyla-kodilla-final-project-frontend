package com.kodilla.project.frontend.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    public MainView() {
        add(buildButtonsLayout());
    }

    private HorizontalLayout buildButtonsLayout() {
        HorizontalLayout buttonsLayout = new HorizontalLayout();
        Button companiesButton = new Button("For Companies");
        Button deliverersButton = new Button("For deliverers");
        Button trackingButton = new Button("Order tracking");
        buttonsLayout.add(companiesButton);
        buttonsLayout.add(deliverersButton);
        buttonsLayout.add(trackingButton);
        return buttonsLayout;
    }
}
