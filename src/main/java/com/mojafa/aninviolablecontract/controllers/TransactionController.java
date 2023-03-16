package com.mojafa.aninviolablecontract.controllers;


import com.mojafa.aninviolablecontract.models.Transaction;
import com.mojafa.aninviolablecontract.repositories.TransactionRepository;
import com.mojafa.aninviolablecontract.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    @RequestMapping("/api/v1/transactions")
    public class TransactionController {

        private final TransactionService transactionService;
        private final TransactionRepository transactionRepository;

        public TransactionController(TransactionService transactionService,
                               TransactionRepository transactionRepository) {
            this.transactionService = transactionService;
            this.transactionRepository = transactionRepository;
        }
    //findAllTrades
    @GetMapping
    public ResponseEntity<List<Transaction>> findAllByAccountNumber(){
        return (ResponseEntity<List<Transaction>>) transactionService.findAllByAccountNumber(123456);
    }
}
