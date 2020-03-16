package com.kodilla.project.frontend.views.components;

import com.kodilla.project.frontend.domain.Company;
import com.kodilla.project.frontend.views.MainView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.server.VaadinSession;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class HeaderLayout extends HorizontalLayout {

    public HeaderLayout(Company company) {
        Text welcomeText = new Text("You are logged in as supplier: " + company.getLogin());
        Button logoutButton = new Button("Log out");
        logoutButton.addClickListener(e -> {
            VaadinSession.getCurrent().setAttribute(Company.class, null);
            UI.getCurrent().navigate(MainView.class);
        });
        add(welcomeText);
        add(logoutButton);
    }
}
