package com.kodilla.project.frontend.views;

import com.kodilla.project.frontend.creator.NewDriverCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "deliverer/register")
public class RegisterDriverView extends VerticalLayout {

    @Autowired
    private NewDriverCreator driverCreator;

    public RegisterDriverView() {
        add(buildDriverRegisterLayout());
    }

    private VerticalLayout buildDriverRegisterLayout() {
        VerticalLayout registerDriverLayout = new VerticalLayout();
        TextField loginField = new TextField();
        loginField.setLabel("New company login");
        loginField.setPlaceholder("Type login here");
        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("New password");
        passwordField.setPlaceholder("Enter new password");
        passwordField.setValue("password");
        Button registerButton = new Button("Register");
        registerButton.addClickListener(e -> {
            if(loginField.getValue().isEmpty() || passwordField.getValue().isEmpty()) {
                Notification.show("Error: empty login or password field!");
            }
            else {
                driverCreator.createNewDriver(loginField.getValue(), passwordField.getValue());
            }
        });
        registerDriverLayout.add(loginField);
        registerDriverLayout.add(passwordField);
        registerDriverLayout.add(registerButton);
        return registerDriverLayout;
    }
}
