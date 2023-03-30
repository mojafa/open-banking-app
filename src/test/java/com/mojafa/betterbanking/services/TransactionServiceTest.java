package com.mojafa.betterbanking.services;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
class TransactionServiceTest {
    @Autowired
    private TransactionService transactionService;
    @Test
    public void testTransactionCount() {
        assertEquals(1, transactionService.findAllByAccountNumber(1234567).size());
    }
}
