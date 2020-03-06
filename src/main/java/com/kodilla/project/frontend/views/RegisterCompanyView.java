package com.kodilla.project.frontend.views;

import com.kodilla.project.frontend.creator.NewCompanyCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "company/register")
public class RegisterCompanyView extends VerticalLayout {

    @Autowired
    private NewCompanyCreator companyCreator;

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
            companyCreator.createNewCompany(loginField.getValue(), passwordField.getValue() );
        });
        registerCompanyLayout.add(loginField);
        registerCompanyLayout.add(passwordField);
        registerCompanyLayout.add(registerButton);
        return registerCompanyLayout;
    }
}
