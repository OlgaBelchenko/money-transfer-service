package org.example.moneytransferservice.repository;

import org.example.moneytransferservice.model.ConfirmOperation;
import org.example.moneytransferservice.model.OperationResult;
import org.example.moneytransferservice.model.Transfer;

public interface TransferRepository {
    OperationResult saveTransfer(Transfer transfer);

    OperationResult confirmOperation(ConfirmOperation confirmOperation);

    public String getLatestId();

    public Transfer getTransferById(String id);
}
