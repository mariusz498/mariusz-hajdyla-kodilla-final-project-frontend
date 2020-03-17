package com.kodilla.project.frontend.views.components;

import com.kodilla.project.frontend.client.BackendClient;
import com.kodilla.project.frontend.domain.Company;
import com.kodilla.project.frontend.domain.Driver;
import com.kodilla.project.frontend.domain.User;
import com.kodilla.project.frontend.views.MainView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.server.VaadinSession;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class HeaderLayout extends HorizontalLayout {

    public HeaderLayout(User user) {
        BackendClient backendClient = new BackendClient();
        Text welcomeText = new Text("You are logged in as: " + user.getLogin());
        Long userId = user.getId();
        Button logoutButton = new Button("Log out");
        logoutButton.addClickListener(e -> {
            VaadinSession.getCurrent().setAttribute(Company.class, null);
            VaadinSession.getCurrent().setAttribute(Driver.class, null);
            UI.getCurrent().navigate(MainView.class);
        });
        Button deleteButton = new Button("Delete account");
        deleteButton.addClickListener(e -> {
            backendClient.deleteCompany(userId);
            VaadinSession.getCurrent().setAttribute(Company.class, null);
            VaadinSession.getCurrent().setAttribute(Driver.class, null);
            UI.getCurrent().navigate(MainView.class);
            Notification.show("Account has been deleted.");
        });
        add(welcomeText);
        add(logoutButton);
        add(deleteButton);
    }
}
