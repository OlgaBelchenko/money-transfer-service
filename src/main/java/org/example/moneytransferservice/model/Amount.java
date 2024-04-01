package org.example.moneytransferservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Amount {
    private int value;
    private String currency;
}
