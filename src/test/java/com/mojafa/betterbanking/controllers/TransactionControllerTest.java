package com.mojafa.betterbanking.controllers;
import mojafa.betterbanking.BetterBankingApplication;
import mojafa.betterbanking.models.Transaction;
import mojafa.betterbanking.services.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@AutoConfigureMockMvc
@SpringBootTest(classes = BetterBankingApplication.class)
public class TransactionControllerTest {

    @MockBean private TransactionService transactionService;

    @Test
    public void testTransactions() throws Exception {
        doReturn(List.of(new Transaction())).when(transactionService).findAllByAccountNumber(anyInt());

        mockMvc.perform(
                        get("/api/v1/transactions/12345678"))
                .andExpect(status().isOk());
    }

    @Autowired private MockMvc mockMvc;
}