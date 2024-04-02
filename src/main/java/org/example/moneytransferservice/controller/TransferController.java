package org.example.moneytransferservice.controller;

import org.example.moneytransferservice.exception.ErrorInputData;
import org.example.moneytransferservice.model.ConfirmOperation;
import org.example.moneytransferservice.model.OperationResult;
import org.example.moneytransferservice.model.Transfer;
import org.springframework.http.ResponseEntity;

public interface TransferController {
    ResponseEntity<OperationResult> transfer(Transfer transfer) throws ErrorInputData;

    ResponseEntity<OperationResult> confirmOperation(ConfirmOperation confirmOperation) throws ErrorInputData;
}
