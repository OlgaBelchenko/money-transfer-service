package org.example.moneytransferservice.model;

import lombok.Getter;

@Getter
public class Amount {
    private int value;
    private String currency;

    public Amount(int value, String currency) {
        this.value = value;
        this.currency = currency;
    }
}
