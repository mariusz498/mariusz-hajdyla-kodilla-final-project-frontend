package com.kodilla.project.frontend.creator;

import org.springframework.stereotype.Component;

@Component
public interface UserCreator {
    void createNewUser(String login, String password);

    String getUserType();
}
