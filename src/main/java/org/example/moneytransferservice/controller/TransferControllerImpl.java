package org.example.moneytransferservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.moneytransferservice.logger.Logger;
import org.example.moneytransferservice.model.Confirmation;
import org.example.moneytransferservice.model.Transfer;
import org.example.moneytransferservice.model.OperationResult;
import org.example.moneytransferservice.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TransferControllerImpl implements TransferController {
    private final Logger logger = Logger.getInstance();
    private final TransferService transferService;

    @Override
    @PostMapping("/transfer")
    public ResponseEntity<OperationResult> transfer(@Valid @RequestBody Transfer transfer) {
        // TODO log
        OperationResult operationResult = transferService.transfer(transfer);
        return ResponseEntity.ok(operationResult);
    }

    @Override
    @PostMapping("/confirmOperation")
    public ResponseEntity<OperationResult> confirmOperation(@Valid @RequestBody Confirmation confirmation) {
        // TODO log
        OperationResult operationResult = transferService.confirm(confirmation);
        return ResponseEntity.ok(operationResult);
    }
}
