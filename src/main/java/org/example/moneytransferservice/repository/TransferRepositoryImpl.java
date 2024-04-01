package org.example.moneytransferservice.repository;

import lombok.Getter;
import org.example.moneytransferservice.logger.Logger;
import org.example.moneytransferservice.model.Confirmation;
import org.example.moneytransferservice.model.Transfer;
import org.example.moneytransferservice.model.OperationResult;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Repository
public class TransferRepositoryImpl implements TransferRepository {
    private final Logger logger = Logger.getInstance();
    private final Map<Long, Transfer> transferOperations;
    private final List<Confirmation> confirmations;

    public TransferRepositoryImpl() {
        transferOperations = new ConcurrentHashMap<>();
        confirmations = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public OperationResult saveTransfer(Transfer transfer) {
        long transferId = transfer.getId();
        transferOperations.put(transferId, transfer);
        return new OperationResult(transferId, "Операция выполнена");
    }

    @Override
    public OperationResult confirmTransfer(Confirmation confirmation) {
        confirmations.add(confirmation);
        return new OperationResult(confirmation.getTransferId(), "Операция подтверждена");
    }

    public long getMaxTransferId() {
        return transferOperations
                .keySet()
                .stream()
                .max(Comparator.naturalOrder())
                .get();
    }

    public Transfer getTransferById(long id) {
        return transferOperations.getOrDefault(id, null);
    }
}
