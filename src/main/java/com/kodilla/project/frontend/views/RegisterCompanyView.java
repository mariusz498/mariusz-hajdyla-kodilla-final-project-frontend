package com.kodilla.project.frontend.views;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kodilla.project.frontend.client.BackendClient;
import com.kodilla.project.frontend.domain.Company;
import com.kodilla.project.frontend.encoder.MD5Encoder;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@Route(value = "company/register")
public class RegisterCompanyView extends VerticalLayout {

    @Autowired
    BackendClient backendClient;

    @Autowired
    MD5Encoder encoder;

    public RegisterCompanyView() {
        add(buildCompanyRegisterLayout());
    }

    private VerticalLayout buildCompanyRegisterLayout() {
        VerticalLayout registerCompanyLayout = new VerticalLayout();
        TextField loginField = new TextField();
        loginField.setLabel("New company login");
        loginField.setPlaceholder("Type login here");
        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("New password");
        passwordField.setPlaceholder("Enter new password");
        passwordField.setValue("password");
        Button registerButton = new Button("Register");
        registerButton.addClickListener(e -> {
            String passwordMd5 = null;
            try {
                passwordMd5 = encoder.encode(passwordField.getValue());
            } catch (NoSuchAlgorithmException ex) {
                ex.printStackTrace();
            }
            Company company = new Company(loginField.getValue(), passwordMd5, new ArrayList<>());
            try {
                boolean status = backendClient.createCompany(company);
                System.out.println(status);
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
            }
        });
        registerCompanyLayout.add(loginField);
        registerCompanyLayout.add(passwordField);
        registerCompanyLayout.add(registerButton);
        return registerCompanyLayout;
    }
}
