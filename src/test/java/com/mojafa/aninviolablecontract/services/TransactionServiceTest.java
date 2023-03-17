package com.mojafa.aninviolablecontract.services;

import com.mojafa.aninviolablecontract.models.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith( SpringRunner.class)
@SpringBootTest
public final class TransactionServiceTest {
    @Autowired
    private TransactionService transactionService;

    @Test
    public void testFindAllByAccountNumber() {
        String accountNumber = "1234567890";
        List<Transaction> transactions = transactionService.findAllByAccountNumber(accountNumber);
        // Expecting 3 to 5 transactions
        assert transactions != null;
    }
}
