package org.example.moneytransferservice.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OperationResult {
    long transferId;
    String result;

    @Override
    public String toString() {
        return "OperationResult{" +
                "id='" + transferId + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}