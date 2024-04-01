package org.example.moneytransferservice.service;

import org.example.moneytransferservice.exception.ErrorInputData;
import org.example.moneytransferservice.model.Transfer;
import org.example.moneytransferservice.model.Confirmation;
import org.example.moneytransferservice.model.OperationResult;

public interface TransferService {
    OperationResult transfer(Transfer transfer);
    OperationResult confirm(Confirmation confirmation) throws ErrorInputData;
}
