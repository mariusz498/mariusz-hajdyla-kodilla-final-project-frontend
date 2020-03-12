package com.kodilla.project.frontend.views;

import com.kodilla.project.frontend.client.BackendClient;

import com.kodilla.project.frontend.domain.Company;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "company/main")
@PageTitle("CompanyView")
public class CompanyLoggedView extends VerticalLayout {

    @Autowired
    private Company company;

    @Autowired
    private BackendClient backendClient;

    public CompanyLoggedView() {
        company = VaadinSession.getCurrent().getAttribute(Company.class);
        add(headerLayout());
    }

    private HorizontalLayout headerLayout() {
        HorizontalLayout layout = new HorizontalLayout();
        Text welcomeText = new Text("You are logged in as Company (sender): " + company.getLogin());
        Button logoutButton = new Button("Log out");
        logoutButton.addClickListener(e -> {
            VaadinSession.getCurrent().setAttribute(Company.class, null);
            UI.getCurrent().navigate(MainView.class);
        });
        layout.add(welcomeText);
        layout.add(logoutButton);
        return layout;
    }
}
