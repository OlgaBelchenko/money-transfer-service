package org.example.moneytransferservice.repository;

import org.example.moneytransferservice.model.ConfirmOperation;
import org.example.moneytransferservice.model.Transfer;
import org.example.moneytransferservice.model.OperationResult;

public interface TransferRepository {
    OperationResult saveTransfer(Transfer transfer);
    OperationResult confirmOperation(ConfirmOperation confirmOperation);

    public int getLatestId();

    public Transfer getTransferById(String id);
}
