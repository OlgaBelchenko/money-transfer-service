package org.example.moneytransferservice.service;

import org.example.moneytransferservice.repository.TransferRepository;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
    private TransferRepository repository;

    public TransferService(TransferRepository repository) {
        this.repository = repository;
    }



}
