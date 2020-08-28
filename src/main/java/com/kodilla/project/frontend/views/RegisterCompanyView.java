package com.kodilla.project.frontend.views;

import com.kodilla.project.frontend.creator.NewCompanyCreator;
import com.kodilla.project.frontend.views.components.RegistrationPanel;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Route(value = "company/register")
@Component
public class RegisterCompanyView extends VerticalLayout {

    @Autowired
    private NewCompanyCreator companyCreator;

    public RegisterCompanyView() {
        add(buildCompanyRegisterLayout());
    }

    private VerticalLayout buildCompanyRegisterLayout() {
        RegistrationPanel panel = new RegistrationPanel(companyCreator);
        return panel.buildRegistrationLayout();
    }
}
