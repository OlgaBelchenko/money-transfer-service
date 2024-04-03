package org.example.moneytransferservice.controller;

import org.example.moneytransferservice.model.ConfirmOperation;
import org.example.moneytransferservice.model.OperationResult;
import org.example.moneytransferservice.model.Transfer;
import org.example.moneytransferservice.service.TransferServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TransferControllerImplTest {
    @Mock
    private TransferServiceImpl transferService;

    @InjectMocks
    private TransferControllerImpl transferController;

    @Test
    void testTransfer() {
        Transfer transfer = mock(Transfer.class);
        ResponseEntity<OperationResult> response = transferController.transfer(transfer);

        verify(transferService).transfer(transfer);
        assertNotNull(response);
    }

    @Test
    void testConfirmOperation() {
        ConfirmOperation confirmOperation = mock(ConfirmOperation.class);
        ResponseEntity<OperationResult> response = transferController.confirmOperation(confirmOperation);

        verify(transferService).confirm(confirmOperation);
        assertNotNull(response);
    }
}