package com.kodilla.project.frontend.views;


import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Tag("sa-login-view")
@Route(value = "company/login")
@PageTitle("Login")
public class CompanyLoginView extends VerticalLayout {

    public CompanyLoginView() {
        TextField loginField = new TextField();
        loginField.setLabel("Company login");
        loginField.setPlaceholder("Login");
        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("Password");
        passwordField.setPlaceholder("Enter password");
        passwordField.setValue("secret1");
        Button loginButton = new Button("Login");
        add(loginField);
        add(passwordField);
        add(loginButton);
    }
}
