package com.kodilla.project.frontend.views;

import com.kodilla.project.frontend.client.BackendClient;
import com.kodilla.project.frontend.domain.CompanyDto;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "company/main")
@PageTitle("CompanyView")
public class CompanyLoggedView extends VerticalLayout implements HasUrlParameter<String> {

    private CompanyDto company;

    @Autowired
    BackendClient backendClient;

    @Override
    public void setParameter(BeforeEvent event, String parameter) {
        company = backendClient.getCompanyByLogin(parameter);
    }

    public CompanyLoggedView() {
       add(buildCompanyCredentials());
    }
    private HorizontalLayout buildCompanyCredentials() {
        HorizontalLayout mainLayout = new HorizontalLayout();
        Text companyLogin = new Text(company.getLogin());
        mainLayout.add(companyLogin);
        return mainLayout;
    }
}
