package com.kodilla.project.frontend.views.components;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CreateOrderLayout extends HorizontalLayout {

    @Autowired
    OriginLocationLayout originLocationLayout;

    @Autowired
    DestinationLocationLayout destinationLocationLayout;

    @Autowired
    OrderOptions orderOptions;

    @Autowired
    CurrencyCombo currencyCombo;

    public CreateOrderLayout() {
        setVisible(false);
        //add(originLocationLayout);
        //add(destinationLocationLayout);
        //add(orderOptions);
        //add(currencyCombo);
    }
}
