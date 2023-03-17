package com.mojafa.aninviolablecontract.services;

import com.mojafa.aninviolablecontract.dto.TransactionDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    public List<Transaction> findAllByAccountNumber(long accountNumber) {
        return transactionRepository.getTransactionsByAccountNumber(accountNumber);
    }
}



