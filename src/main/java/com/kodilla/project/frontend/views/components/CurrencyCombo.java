package com.kodilla.project.frontend.views.components;

import com.vaadin.flow.component.combobox.ComboBox;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CurrencyCombo extends ComboBox<String> {
    public CurrencyCombo() {
        setItems("EUR", "PLN", "GBP", "USD", "RUB", "CHF");
        setValue("EUR");
        setLabel("For currency other than Euro 5% fee will be added.");
    }
}
