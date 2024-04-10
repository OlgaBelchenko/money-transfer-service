package org.example.moneytransferservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfirmOperation {
    private String operationId;
    private String code;
}
