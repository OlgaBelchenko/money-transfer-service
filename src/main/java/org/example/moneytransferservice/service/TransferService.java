package org.example.moneytransferservice.service;

import org.example.moneytransferservice.exception.ErrorInputData;
import org.example.moneytransferservice.exception.ErrorTransferConfirmation;
import org.example.moneytransferservice.model.ConfirmOperation;
import org.example.moneytransferservice.model.OperationResult;
import org.example.moneytransferservice.model.Transfer;

public interface TransferService {
    OperationResult transfer(Transfer transfer);

    OperationResult confirm(ConfirmOperation confirmOperation) throws ErrorTransferConfirmation, ErrorInputData;
}
