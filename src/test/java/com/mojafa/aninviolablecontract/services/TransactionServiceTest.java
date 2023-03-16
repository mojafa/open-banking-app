package com.mojafa.aninviolablecontract.services;

import com.mojafa.aninviolablecontract.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

@SpringBootTest
public class TransactionServiceTest {
    @Autowired
    TransactionService service;

    @Test
    void testTransactionService() {
        List<Transaction> transaction = service.findAllByAccountNumber(123456);

//         assertTrue(transaction.stream().anyMatch(t -> {
//         	return t.getAccountNumber().equals(123456);
//         }));
        assertTrue(!transaction.isEmpty());
    }
}