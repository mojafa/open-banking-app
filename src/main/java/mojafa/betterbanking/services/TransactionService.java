package com.mojafa.betterbanking.services;

import com.mojafa.betterbanking.models.Transaction;
import com.mojafa.betterbanking.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    public List<Transaction> findAllByAccountNumber(long accountNumber) {
        return transactionRepository.findAllByAccountNumber(accountNumber);
    }
}

//    //findAll
//    @Transactional
//    public ResponseEntity<List<Trade>> findAllTrades() {
//        //List<Trade> trade = tradeRepository.findAll();
//        return new ResponseEntity<>(tradeRepository.findAllByOrderByIdAsc(), HttpStatus.OK);
//    }


