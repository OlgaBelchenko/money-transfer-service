package org.example.moneytransferservice.exception;

public class ErrorTransferConfirmation extends RuntimeException {
    public ErrorTransferConfirmation(String message) {
        super(message);
    }
}
