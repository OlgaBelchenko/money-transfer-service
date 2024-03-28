package org.example.moneytransferservice.controller;

import org.example.moneytransferservice.model.Amount;
import org.example.moneytransferservice.repository.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@Validated @RequestBody Amount amount) {
        // TODO
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/confirmOperation")
    public ResponseEntity<String> confirmOperation(@Validated @RequestBody Operation confirmOperation) {
        // TODO
        return ResponseEntity.ok("OK");
    }
}
