package com.mojafa.aninviolablecontract.services;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;


public final class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;


    @Test
    void testTransactions(){

        int size = transactionService.findAllByAccountNumber(123L).size();
        assertTrue("Error, there are not 3 transactions", size == 3);
    }
}
