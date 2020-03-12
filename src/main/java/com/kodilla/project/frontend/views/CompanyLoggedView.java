package com.kodilla.project.frontend.views;

import com.kodilla.project.frontend.client.BackendClient;

import com.kodilla.project.frontend.domain.Company;
import com.kodilla.project.frontend.mapper.CompanyMapper;
import com.vaadin.flow.component.Text;
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

    @Autowired
    private CompanyMapper companyMapper;

    public CompanyLoggedView() {
        company = VaadinSession.getCurrent().getAttribute(Company.class);
        Text companyName = new Text(company.getLogin());
        add(companyName);
    }
}
