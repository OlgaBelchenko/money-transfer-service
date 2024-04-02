package org.example.moneytransferservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.moneytransferservice.model.ConfirmOperation;
import org.example.moneytransferservice.model.OperationResult;
import org.example.moneytransferservice.model.Transfer;
import org.example.moneytransferservice.service.TransferServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin
@RestController
public class TransferControllerImpl implements TransferController {
    private final TransferServiceImpl transferService;

    @Override
    @PostMapping("/transfer")
    public ResponseEntity<OperationResult> transfer(@Valid @RequestBody Transfer transfer) {
        OperationResult operationResult = transferService.transfer(transfer);
        return ResponseEntity.ok(operationResult);
    }

    @Override
    @PostMapping("/confirmOperation")
    public ResponseEntity<OperationResult> confirmOperation(@RequestBody ConfirmOperation confirmOperation) {
        OperationResult operationResult = transferService.confirm(confirmOperation);
        return ResponseEntity.ok(operationResult);
    }
}
