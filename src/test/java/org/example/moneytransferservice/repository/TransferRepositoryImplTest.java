package org.example.moneytransferservice.repository;

import org.example.moneytransferservice.model.ConfirmOperation;
import org.example.moneytransferservice.model.OperationResult;
import org.example.moneytransferservice.model.Transfer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class TransferRepositoryImplTest {

    private TransferRepositoryImpl repository;
    private final String TRANSFER_ID = "20";
    private Transfer TRANSFER;

    @BeforeEach
    void setUp() {
        repository = new TransferRepositoryImpl();
        TRANSFER = mock(Transfer.class);
        TRANSFER.setId(TRANSFER_ID);
        Map<String, Transfer> mockedMap = new HashMap<>(new ConcurrentHashMap<>(){{
            put(TRANSFER_ID, TRANSFER);
        }});
        ReflectionTestUtils.setField(repository, "transferOperations", mockedMap);
    }

    @Test
    void testSaveTransfer() {
        int expectedSize = 2;
        Transfer transfer = new Transfer();
        String id = "30";
        transfer.setId(id);

        repository.saveTransfer(transfer);
        int actualSize = repository.getTransferOperations().size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    void testGetLatestId() {
        String actualId = repository.getLatestId();
        assertEquals(TRANSFER_ID, actualId);
    }

    @Test
    void testGetTransferById() {
        Transfer actualTransfer = repository.getTransferById(TRANSFER_ID);
        assertEquals(TRANSFER, actualTransfer);
    }

    @Test
    void confirmOperation() {
        ConfirmOperation confirmOperation = mock(ConfirmOperation.class);
        OperationResult result = repository.confirmOperation(confirmOperation);
        assertNotNull(result);
    }
}