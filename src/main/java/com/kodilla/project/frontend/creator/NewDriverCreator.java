package com.kodilla.project.frontend.creator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kodilla.project.frontend.client.BackendClient;
import com.kodilla.project.frontend.domain.Driver;
import com.kodilla.project.frontend.encoder.MD5Encoder;
import com.kodilla.project.frontend.views.MainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.Notification;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewDriverCreator implements UserCreator {

    private final String userType = "driver";

    @Autowired
    private BackendClient backendClient;

    @Autowired
    MD5Encoder encoder;

    public void createNewUser(String login, String password) {
        if (backendClient.getDriverByLogin(login).getLogin() == null) {
            String passwordMd5 = null;
            try {
                passwordMd5 = encoder.encode(password);
            } catch (NoSuchAlgorithmException ex) {
                ex.printStackTrace();
            }
            Driver driver = new Driver(null, login, passwordMd5, new ArrayList<>());
            boolean status = false;
            try {
                status = backendClient.createDriver(driver);
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
            }
            if(status) {
                UI.getCurrent().navigate(MainView.class);
                Notification.show("Registration successful! Now you can log in.");
            }
        }
        else {
            Notification.show(userType.substring(0,1).toUpperCase() + userType.substring(1) + " name is unavailable. Please choose another name.");
        }
    }
}