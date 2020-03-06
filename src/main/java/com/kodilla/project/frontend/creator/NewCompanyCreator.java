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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewCompanyCreator {

    @Autowired
    private BackendClient backendClient;

    @Autowired
    MD5Encoder encoder;

    public void createNewCompany(String login, String password) {
        if (backendClient.getCompanyByLogin(login).getLogin() == null) {
            String passwordMd5 = null;
            try {
                passwordMd5 = encoder.encode(password);
            } catch (NoSuchAlgorithmException ex) {
                ex.printStackTrace();
            }
            Company company = new Company(login, passwordMd5, new ArrayList<>());
            boolean status = false;
            try {
                status = backendClient.createCompany(company);
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
            }
            if(status) {
                UI.getCurrent().navigate(MainView.class);
                Notification.show("Registration successful! Now you can log in");
            }
        }
        else {
            Notification.show("Company name is unavailable. Please choose another name");
        }
    }
}