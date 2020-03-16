package com.kodilla.project.frontend.views.components;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class OrderOptions extends VerticalLayout {
    private Checkbox express = new Checkbox("Express");
    private Checkbox ADR = new Checkbox("ADR");
    private Checkbox fragile = new Checkbox("Fragile");

    public OrderOptions() {
        add(express, ADR, fragile);
    }
}
