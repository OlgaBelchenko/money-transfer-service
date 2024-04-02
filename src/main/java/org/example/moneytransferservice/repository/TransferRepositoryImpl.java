package org.example.moneytransferservice.repository;

import org.example.moneytransferservice.model.ConfirmOperation;
import org.example.moneytransferservice.model.OperationResult;
import org.example.moneytransferservice.model.Transfer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TransferRepositoryImpl implements TransferRepository {
    private final Map<String, Transfer> transferOperations;
    private final List<ConfirmOperation> confirmOperations;

    public TransferRepositoryImpl() {
        transferOperations = new ConcurrentHashMap<>();
        confirmOperations = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public OperationResult saveTransfer(Transfer transfer) {
        String id = transfer.getId();
        transferOperations.put(id, transfer);
        return new OperationResult(id, "Деньги переведены");
    }

    @Override
    public OperationResult confirmOperation(ConfirmOperation confirmOperation) {
        confirmOperations.add(confirmOperation);
        return new OperationResult(confirmOperation.getId(), "Операция подтверждена");
    }

    @Override
    public int getLatestId() {
        if (transferOperations.isEmpty()) return 0;
        return transferOperations
                .keySet()
                .stream()
                .mapToInt(Integer::parseInt)
                .max()
                .getAsInt();
    }

    @Override
    public Transfer getTransferById(String id) {
        if (id == null) return null;
        return transferOperations.get(id);
    }
}
