package com.mojafa.aninviolablecontract.dto;

public record TransactionDTO(
    Long id,
    Integer accountNumber,
    String transactionType,
    String transactionDate,
    String transactionAmount,
    String transactionCurrency,
    String transactionStatus,
    String transactionDescription) {
}
