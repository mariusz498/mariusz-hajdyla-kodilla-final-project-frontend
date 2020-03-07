package com.kodilla.project.frontend.client;

import com.kodilla.project.frontend.encoder.MD5Encoder;
import com.vaadin.flow.component.notification.Notification;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Authenticator {

    @Autowired
    private MD5Encoder encoder;

    @Autowired
    private BackendClient backendClient;

    public boolean authenticateCompany(String login, String password) throws NoSuchAlgorithmException {
        String companyLogin = backendClient.getCompanyByLogin(login).getLogin();
        String companyPasswordMD5 = backendClient.getCompanyByLogin(login).getPasswordMD5();
        String encodedPassword = encoder.encode(password);
        if(login.equals(companyLogin) && encodedPassword.equals(companyPasswordMD5)) {
            return true;
        }
        Notification.show("Invalid login or password! Please try again.");
        return false;
    }
}
