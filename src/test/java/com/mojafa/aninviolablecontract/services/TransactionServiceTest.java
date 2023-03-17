package com.mojafa.aninviolablecontract.services;

import com.mojafa.aninviolablecontract.dto.TransactionDTO;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;


public final class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;


    @Test
    void testTransactions(){

        int size = transactionService.findAllByAccountNumber(123L).size();
        assertTrue("Error, there are not 3 transactions", size == 3);
    }
}
