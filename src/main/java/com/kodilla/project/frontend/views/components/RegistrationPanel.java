package com.kodilla.project.frontend.views.components;

import com.kodilla.project.frontend.creator.UserCreator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class RegistrationPanel extends VerticalLayout {

    public RegistrationPanel(UserCreator userCreator) {
        TextField loginField = new TextField();
        loginField.setLabel("New " + userCreator.getUserType() + " login");
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
                userCreator.createNewUser(loginField.getValue(), passwordField.getValue());
            }
        });
        this.add(loginField);
        this.add(passwordField);
        this.add(registerButton);
    }
}
