package com.kodilla.project.frontend.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    public MainView() {
        add(buildMainLayout());
    }

    private HorizontalLayout buildMainLayout() {
        HorizontalLayout mainLayout = new HorizontalLayout();
        mainLayout.setWidthFull();
        mainLayout.add(buildCompanyLoginLayout());
        mainLayout.add(buildDriverLoginLayout());
        mainLayout.add(buildOrderFinder());
        return mainLayout;
    }
    
    private VerticalLayout buildCompanyLoginLayout() {
        VerticalLayout companyLoginLayout = new VerticalLayout();
        TextField loginField = new TextField();
        loginField.setLabel("Company login");
        loginField.setPlaceholder("Login");
        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("Password");
        passwordField.setPlaceholder("Enter password");
        passwordField.setValue("password");
        Button loginButton = new Button("Login");
        Text registerText = new Text("Don't have account? Register now!");
        Button registerButton = new Button("Register");
        registerButton.addClickListener(e -> UI.getCurrent().navigate(RegisterCompanyView.class));
        companyLoginLayout.add(loginField);
        companyLoginLayout.add(passwordField);
        companyLoginLayout.add(loginButton);
        companyLoginLayout.add(registerText);
        companyLoginLayout.add(registerButton);
        return companyLoginLayout;
    }

    private VerticalLayout buildDriverLoginLayout() {
        VerticalLayout driverLoginLayout = new VerticalLayout();
        TextField loginField = new TextField();
        loginField.setLabel("Deliverer login");
        loginField.setPlaceholder("Login");
        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("Password");
        passwordField.setPlaceholder("Enter password");
        passwordField.setValue("password");
        Button loginButton = new Button("Login");
        driverLoginLayout.add(loginField);
        driverLoginLayout.add(passwordField);
        driverLoginLayout.add(loginButton);
        return driverLoginLayout;
    }

    private VerticalLayout buildOrderFinder() {
        VerticalLayout orderFinder = new VerticalLayout();
        TextField idField = new TextField();
        idField.setLabel("Order ID");
        idField.setPlaceholder("Order ID number");
        Button findButton = new Button("Find order");
        orderFinder.add(idField);
        orderFinder.add(findButton);
        return orderFinder;
    }
}
