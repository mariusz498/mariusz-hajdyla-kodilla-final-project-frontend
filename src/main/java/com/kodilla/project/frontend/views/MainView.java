package com.kodilla.project.frontend.views;

import com.kodilla.project.frontend.client.Authenticator;
import com.kodilla.project.frontend.client.BackendClient;
import com.kodilla.project.frontend.countries.CountriesWithCodes;
import com.kodilla.project.frontend.domain.*;
import com.kodilla.project.frontend.mapper.CompanyMapper;
import com.kodilla.project.frontend.mapper.DriverMapper;
import com.kodilla.project.frontend.mapper.OrderMapper;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import java.security.NoSuchAlgorithmException;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Route
@Component
public class MainView extends VerticalLayout {

    @Autowired
    Authenticator authenticator;

    @Autowired
    Company company;

    @Autowired
    Driver driver;

    @Autowired
    Order order;

    @Autowired
    CountriesWithCodes countriesWithCodes;

    @Autowired
    OrdersList ordersList;

    @Autowired
    CompanyMapper companyMapper;

    @Autowired
    DriverMapper driverMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    BackendClient backendClient;


    public MainView() {
        add(headerText());
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

    private Text headerText(){
        return new Text("Welcome to SmartShipping, a platform to automatic land transport management!");
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
        loginButton.addClickListener(e -> {
            boolean authenticatorResponse = false;
            if(loginField.getValue().isEmpty() || passwordField.getValue().isEmpty()) {
                Notification.show("Error: empty login or password field!");
            }
            else {
                try {
                    authenticatorResponse = authenticator.authenticateCompany(loginField.getValue(), passwordField.getValue());
                } catch (NoSuchAlgorithmException ex) {
                    ex.printStackTrace();
                }
            }
            if(authenticatorResponse) {
                company = companyMapper.mapToCompany(backendClient.getCompanyByLogin(loginField.getValue()));
                ordersList.setOrdersList(orderMapper.mapToOrdersList(backendClient.getOrdersByCompany(company.getLogin())));
                VaadinSession.getCurrent().setAttribute(OrdersList.class, ordersList);
                VaadinSession.getCurrent().setAttribute(Company.class, company);
                UI.getCurrent().navigate(CompanyLoggedView.class);
            }
        });
        Text registerText = new Text("Don't have account yet? Register now!");
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
        loginButton.addClickListener(e -> {
            boolean authenticatorResponse = false;
            if(loginField.getValue().isEmpty() || passwordField.getValue().isEmpty()) {
                Notification.show("Error: empty login or password field!");
            }
            else {
                try {
                    authenticatorResponse = authenticator.authenticateDriver(loginField.getValue(), passwordField.getValue());
                } catch (NoSuchAlgorithmException ex) {
                    ex.printStackTrace();
                }
            }
            if(authenticatorResponse) {
                driver = driverMapper.mapToDriver(backendClient.getDriverByLogin(loginField.getValue()));
                VaadinSession.getCurrent().setAttribute(Driver.class, driver);
                UI.getCurrent().navigate(DriverLoggedView.class);
            }
        });
        Text registerText = new Text("Don't have account yet? Register now!");
        Button registerButton = new Button("Register");
        registerButton.addClickListener(e -> UI.getCurrent().navigate(RegisterDriverView.class));
        driverLoginLayout.add(loginField);
        driverLoginLayout.add(passwordField);
        driverLoginLayout.add(loginButton);
        driverLoginLayout.add(registerText);
        driverLoginLayout.add(registerButton);
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
