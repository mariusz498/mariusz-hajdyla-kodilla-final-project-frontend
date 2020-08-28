package com.kodilla.project.frontend.creator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kodilla.project.frontend.client.BackendClient;
import com.kodilla.project.frontend.domain.Company;
import com.kodilla.project.frontend.encoder.MD5Encoder;
import com.kodilla.project.frontend.views.MainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.Notification;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class NewCompanyCreator implements UserCreator {

    private final String userType = "company";

    @Autowired
    private BackendClient backendClient;

    @Autowired
    MD5Encoder encoder;

    public void createNewUser(String login, String password) {
        if (backendClient.getCompanyByLogin(login).getLogin() == null) {
            String passwordMd5 = null;
            try {
                passwordMd5 = encoder.encode(password);
            } catch (NoSuchAlgorithmException ex) {
                ex.printStackTrace();
            }
            Company company = new Company(null, login, passwordMd5, new ArrayList<>());
            boolean status = false;
            try {
                status = backendClient.createCompany(company);
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