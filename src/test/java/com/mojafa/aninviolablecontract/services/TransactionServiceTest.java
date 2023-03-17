package com.mojafa.aninviolablecontract;

import com.mojafa.aninviolablecontract.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class TransactionServiceTest {
    @Autowired
    private TransactionService service;

    @Test
    void testTransactionService() {
        assertEquals(2, service.findAllByAccountNumber(1234567).size());
    }
}

