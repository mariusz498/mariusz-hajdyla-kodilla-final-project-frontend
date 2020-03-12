package com.kodilla.project.frontend.views;

import com.kodilla.project.frontend.client.Authenticator;
import com.kodilla.project.frontend.client.BackendClient;
import com.kodilla.project.frontend.domain.Company;
import com.kodilla.project.frontend.mapper.CompanyMapper;
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

@Route
public class MainView extends VerticalLayout {

    @Autowired
    private Authenticator authenticator;

    @Autowired
    public Company company;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private BackendClient backendClient;

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
                VaadinSession.getCurrent().setAttribute(Company.class,company) ;
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
