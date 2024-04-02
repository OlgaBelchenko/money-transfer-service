package org.example.moneytransferservice.model;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Amount {
    @Positive(message = "Сумма перевода должна быть больше нуля")
    private Integer value;
    private String currency;

    public double calculateCommission() {
        return value / 10000.0;
    }

    public double calculateValue() {
        return value / 100.0;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}
