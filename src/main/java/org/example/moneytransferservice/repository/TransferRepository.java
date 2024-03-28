package org.example.moneytransferservice.repository;

import org.example.moneytransferservice.exception.ExceptionTransferConfirmation;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TransferRepository {
    Map<Long, Transfer> transferOperations;

    public TransferRepository() {
        transferOperations = new ConcurrentHashMap<>();
    }

    public void transfer(Transfer transfer, Operation operation, String code) {
        long id = operation.id();
        if (operation.isConfirmed(id, code)) {
            transferOperations.put(id, transfer);
        } else {
            throw new ExceptionTransferConfirmation("Error confirmation");
        }
    }

    public Transfer getTransferById(long id) {
        return transferOperations.get(id);
    }
}
