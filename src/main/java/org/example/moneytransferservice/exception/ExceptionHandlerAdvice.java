package org.example.moneytransferservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice()
public class ExceptionHandlerAdvice {
    @ExceptionHandler(ErrorTransferConfirmation.class)
    public ResponseEntity<String> ecHandler(ErrorTransferConfirmation e) {
        return new ResponseEntity<>(e.getMessage(), INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ErrorInputData.class)
    public ResponseEntity<String> idHandler(ErrorInputData e) {
        return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
    }
}
