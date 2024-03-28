package org.example.moneytransferservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice()
public class ExceptionHandlerAdvice {
    @ExceptionHandler(ExceptionTransferConfirmation.class)
    public ResponseEntity<String> ecHandler(ExceptionTransferConfirmation e) {
        return new ResponseEntity<>(e.getMessage(), INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ExceptionInputData.class)
    public ResponseEntity<String> idHandler(ExceptionInputData e) {
        return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
    }
}
