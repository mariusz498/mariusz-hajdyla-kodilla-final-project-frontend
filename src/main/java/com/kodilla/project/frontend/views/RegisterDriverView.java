package com.kodilla.project.frontend.views;

import com.kodilla.project.frontend.creator.NewDriverCreator;
import com.kodilla.project.frontend.views.components.RegistrationPanel;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Route(value = "deliverer/register")
@Component
public class RegisterDriverView extends VerticalLayout {

    @Autowired
    private NewDriverCreator driverCreator;

    public RegisterDriverView() {
        add(buildDriverRegisterLayout());
    }

    private VerticalLayout buildDriverRegisterLayout() {
        RegistrationPanel panel = new RegistrationPanel(driverCreator);
        return panel.buildRegistrationLayout();
    }
}
