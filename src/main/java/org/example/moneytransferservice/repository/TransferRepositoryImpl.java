package org.example.moneytransferservice.repository;

import lombok.Getter;
import org.example.moneytransferservice.model.ConfirmOperation;
import org.example.moneytransferservice.model.OperationResult;
import org.example.moneytransferservice.model.Transfer;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Getter
public class TransferRepositoryImpl implements TransferRepository {
    private final Map<String, Transfer> transferOperations;

    public TransferRepositoryImpl() {
        transferOperations = new ConcurrentHashMap<>();
    }

    @Override
    public OperationResult saveTransfer(Transfer transfer) {
        String id = transfer.getId();
        transferOperations.put(id, transfer);
        return new OperationResult(id, "Деньги успешно переведены");
    }

    @Override
    public OperationResult confirmOperation(ConfirmOperation confirmOperation) {
        String id = confirmOperation.getId();
        return id == null ?
                new OperationResult("-1", "Операция не требует подтверждения") : new OperationResult(id, "Операция подтверждена");
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
