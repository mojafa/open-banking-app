package com.mojafa.aninviolablecontract.controllers;


import com.mojafa.aninviolablecontract.dto.TransactionDTO;
import com.mojafa.aninviolablecontract.services.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{accountNumber}")
    public List<Transaction> getTransactions(@PathVariable long accountNumber) {
        List<Transaction> transactions = transactionService.findAllByAccountNumber(accountNumber);
        List<TransactionDTO> transactionDTOs = new ArrayList<>();
        for (Transaction transaction : transactions) {
            // Use ModelMapper to map the fields from the Transaction to the TransactionDTO
            TransactionDTO transactionDTO = new TransactionDTO();
            transactionDTO.setAccountNumber(transaction.getAccountNumber());
            transactionDTO.setAmount(transaction.getAmount());
            transactionDTO.setDate(transaction.getDate());
            transactionDTO.setCurrency(transaction.getCurrency());
            transactionDTOs.add(transactionDTO);
        }
        return transactionDTOs;
    }
}


