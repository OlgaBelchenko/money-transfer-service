package org.example.moneytransferservice.repository;

import com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.pool.StrictConnPool;
import org.example.moneytransferservice.model.Transfer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class TransferRepositoryImplTest {

    TransferRepositoryImpl repository;
    Transfer transfer;

    @BeforeEach
    void setUp() {
        repository = new TransferRepositoryImpl();
        transfer = new Transfer();
        transfer.setId("1");
    }

    @Test
    void testSaveTransfer() {
        int expectedSize = 1;
        repository.saveTransfer(transfer);

        int actualSize = repository.getTransferOperations().size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void confirmOperation() {
    }

    @Test
    void testGetLatestId() {


    }

    @Test
    void testGetTransferById() {

    }
}