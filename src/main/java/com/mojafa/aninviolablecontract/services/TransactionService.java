package com.mojafa.aninviolablecontract.services;

import com.mojafa.aninviolablecontract.models.Transaction;
import com.mojafa.aninviolablecontract.repositories.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;


    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public List<Transaction> findAllByAccountNumber(int i){
        return transactionRepository.findAllByAccountNumber(123456);
    }
}