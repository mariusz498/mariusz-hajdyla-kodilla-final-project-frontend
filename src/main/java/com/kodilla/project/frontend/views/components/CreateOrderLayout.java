package com.kodilla.project.frontend.views.components;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Getter
public class CreateOrderLayout extends HorizontalLayout {
    @Autowired
    private OriginLocationLayout originLocationLayout = new OriginLocationLayout();
    @Autowired
    private DestinationLocationLayout destinationLocationLayout = new DestinationLocationLayout();
    @Autowired
    private OrderOptions orderOptions = new OrderOptions();
    @Autowired
    private CurrencyCombo currencyCombo = new CurrencyCombo();

    public CreateOrderLayout() {
        setVisible(false);
        add(originLocationLayout);
        add(destinationLocationLayout);
        add(orderOptions);
        add(currencyCombo);
    }
}
