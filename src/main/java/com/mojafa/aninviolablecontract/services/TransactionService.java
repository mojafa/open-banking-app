package com.mojafa.aninviolablecontract.services;

import com.mojafa.aninviolablecontract.models.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class TransactionService {
        public List<Transaction> findAllByAccountNumber(String accountNumber) {
            // For now, just return an empty list
//            return new ArrayList<>();
            return Arrays.asList(
                    new Transaction("debit", new Date(), accountNumber, "USD", BigDecimal.valueOf(100.00), "Merchant 1", "Merchant Logo 1"),
                    new Transaction("credit", new Date(), accountNumber, "USD", BigDecimal.valueOf(200.00), "Merchant 2", "Merchant Logo 2"),
                    new Transaction("debit", new Date(), accountNumber, "USD", BigDecimal.valueOf(300.00), "Merchant 3", "Merchant Logo 3")
            );
        }
    }



