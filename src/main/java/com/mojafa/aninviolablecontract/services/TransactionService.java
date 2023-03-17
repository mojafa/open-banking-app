package com.mojafa.aninviolablecontract.services;

import com.mojafa.aninviolablecontract.models.Transaction;
import com.mojafa.aninviolablecontract.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    public List<Transaction> findAllByAccountNumber(long accountNumber) {
        return transactionRepository.findAllByAccountNumber(accountNumber);
    }
}



