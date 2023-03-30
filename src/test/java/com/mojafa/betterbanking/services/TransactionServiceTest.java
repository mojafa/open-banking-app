package com.mojafa.aninviolablecontract.services;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;


class TransactionServiceTest {
    TransactionService transactionService = new TransactionService();
    @Test
    public void testTransactionCount() {
        assertEquals(1, transactionService.findAllByAccountNumber(1234567).size());
    }
}
