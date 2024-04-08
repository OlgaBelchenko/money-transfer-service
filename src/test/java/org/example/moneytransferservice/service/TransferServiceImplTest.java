package org.example.moneytransferservice.service;

import org.example.moneytransferservice.repository.TransferRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class TransferServiceImplTest {

    @Mock
    private TransferRepositoryImpl repository;

    @InjectMocks
    private TransferServiceImpl service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void transfer() {

    }

    @Test
    void confirm() {

    }
}