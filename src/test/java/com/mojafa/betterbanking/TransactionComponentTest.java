package com.mojafa.aninviolablecontract;

import com.mojafa.aninviolablecontract.repositories.TransactionRepository;
import org.assertj.core.api.BDDAssumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.mockito.BDDMockito.given;
@SpringBootTest
public class TransactionComponentTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TransactionRepository transactionRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getTransactions() {
        given(transactionRepository.findById(123L)).willReturn(null);
        BDDAssumptions.assumeThat(transactionRepository.findById(123L)).isNull();
    }

}
