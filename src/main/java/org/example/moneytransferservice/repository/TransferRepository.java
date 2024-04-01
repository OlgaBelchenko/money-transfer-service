package org.example.moneytransferservice.repository;

import org.example.moneytransferservice.model.Confirmation;
import org.example.moneytransferservice.model.Transfer;
import org.example.moneytransferservice.model.OperationResult;

public interface TransferRepository {

    OperationResult saveTransfer(Transfer transfer);
    OperationResult confirmTransfer(Confirmation confirmation);
}
