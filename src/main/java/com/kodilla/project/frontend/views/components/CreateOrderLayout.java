package com.kodilla.project.frontend.views.components;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CreateOrderLayout extends HorizontalLayout {

    @Autowired
    private final OriginLocationLayout originLocationLayout = new OriginLocationLayout();

    @Autowired
    private final DestinationLocationLayout destinationLocationLayout = new DestinationLocationLayout();

    @Autowired
    private final OrderOptions orderOptions = new OrderOptions();

    @Autowired
    private final CurrencyCombo currencyCombo = new CurrencyCombo();

    public CreateOrderLayout() {
        setVisible(false);
        add(originLocationLayout);
        add(destinationLocationLayout);
        add(orderOptions);
        add(currencyCombo);
    }
}
