package org.example.moneytransferservice.service;

import org.example.moneytransferservice.exception.ErrorInputData;
import org.example.moneytransferservice.exception.ErrorTransferConfirmation;
import org.example.moneytransferservice.logger.Logger;
import org.example.moneytransferservice.model.ConfirmOperation;
import org.example.moneytransferservice.model.OperationResult;
import org.example.moneytransferservice.model.Transfer;
import org.example.moneytransferservice.repository.TransferRepository;
import org.example.moneytransferservice.repository.TransferRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {
    private final Logger logger = Logger.getInstance();
    private final String LOG_FILE_PATH = "src/main/resources/logs/log.txt";
    private final TransferRepository repository;
    private final String CODE = "0000";

    public TransferServiceImpl() {
        repository = new TransferRepositoryImpl();
    }

    @Override
    public OperationResult transfer(Transfer transfer) {
        int id = Integer.parseInt(repository.getLatestId()) + 1;
        transfer.setId(String.valueOf(id));

        String logMessage = String.format("Перевод с карты №%s на карту №%s. " +
                        "Сумма перевода:  %.2f, комиссия: %.2f",
                transfer.getCardFromNumber(),
                transfer.getCardToNumber(),
                transfer.getAmount().calculateValue(),
                transfer.getAmount().calculateCommission());
        logger.log(logMessage, LOG_FILE_PATH);
        return repository.saveTransfer(transfer);
    }

    @Override
    public OperationResult confirm(ConfirmOperation confirmOperation) throws ErrorTransferConfirmation, ErrorInputData {
        String id = confirmOperation.getId();
        if (id != null) {
            Transfer transfer = repository.getTransferById(confirmOperation.getId());
            if (transfer != null) {
                transfer.setConfirmationCode(confirmOperation.getCode());
                logMessage(String.format("Код подтверждения для операции с id %s обновлен.", id));
            } else {
                logMessage(String.format("Код подтверждения для операции с id %s обновлен.", id));
                throw new ErrorTransferConfirmation("Перевод не найден");
            }
        }
        return repository.confirmOperation(confirmOperation);

    }

    private void logMessage(String message) {
        logger.log(message, LOG_FILE_PATH);
    }
}
