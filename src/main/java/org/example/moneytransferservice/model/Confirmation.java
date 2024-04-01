package org.example.moneytransferservice.model;

import lombok.Getter;

@Getter
public class Confirmation {
    private long transferId;
    private String code;
}
