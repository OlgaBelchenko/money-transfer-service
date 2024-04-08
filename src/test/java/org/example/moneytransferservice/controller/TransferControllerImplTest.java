package org.example.moneytransferservice.controller;

import org.example.moneytransferservice.model.OperationResult;
import org.example.moneytransferservice.service.TransferServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TransferControllerImplTest {
    @Mock
    private TransferServiceImpl service;

    @InjectMocks
    private TransferControllerImpl controller;

    @Test
    void testTransfer() {
        ResponseEntity<OperationResult> response = controller.transfer(Mockito.any());
        verify(service).transfer(Mockito.any());
        assertNotNull(response);
    }

    @Test
    void testConfirmOperation() {
        ResponseEntity<OperationResult> response = controller.transfer(Mockito.any());
        verify(service).transfer(Mockito.any());
        assertNotNull(response);
    }
}