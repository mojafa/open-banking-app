package com.mojafa.betterbanking.services;

import com.mojafa.betterbanking.BetterBankingApplication;
import mojafa.betterbanking.models.Transaction;
import mojafa.betterbanking.repositories.MerchantDetailsRepository;
import mojafa.betterbanking.repositories.TransactionApiClient;
import mojafa.betterbanking.services.TransactionService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {BetterBankingApplication.class})
public class TransactionServiceTest {
    @Mock private TransactionApiClient transactionApiClient;
    @Mock private MerchantDetailsRepository merchantDetailsRepository;
    @InjectMocks private TransactionService transactionService;

    @DisplayName("test TransactionService with mock TransactionApiClient")
    @Test
    public void testTransactionCount() {
        when(transactionApiClient.findAllByAccountNumber(any()))
                .thenReturn(List.of(new Transaction()));
        assertEquals(1, transactionService.findAllByAccountNumber(1234567).size());
    }
}
