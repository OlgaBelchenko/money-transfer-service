package org.example.moneytransferservice.service;

import lombok.RequiredArgsConstructor;
import org.example.moneytransferservice.exception.ErrorInputData;
import org.example.moneytransferservice.logger.Logger;
import org.example.moneytransferservice.model.Confirmation;
import org.example.moneytransferservice.model.OperationResult;
import org.example.moneytransferservice.model.Transfer;
import org.example.moneytransferservice.repository.TransferRepositoryImpl;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TransferServiceImpl implements TransferService {
    private final Logger logger = Logger.getInstance();
    private final TransferRepositoryImpl repository;

    @Override
    public OperationResult transfer(Transfer transfer) {
        // TODO log
        long id = repository.getMaxTransferId() + 1;
        transfer.setId(id);
        return repository.saveTransfer(transfer);
    }

    @Override
    public OperationResult confirm(Confirmation confirmation) throws ErrorInputData {
        // TODO log
        long id = confirmation.getTransferId();
        Transfer transfer = repository.getTransferById(id);
        if (transfer == null) {
            throw new ErrorInputData("Отсутствует операция с идентификатором " + id);
        }
        // TODO get code
        if ("code".equals(confirmation.getCode())) {
            return repository.confirmTransfer(confirmation);
        } else {
            throw new ErrorInputData("Неверный код подтверждения");
        }
    }
}
