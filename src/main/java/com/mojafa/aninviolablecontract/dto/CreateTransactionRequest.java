package com.mojafa.aninviolablecontract.dto;

public record CreateTransactionRequest(
    int id,
    Type type,
    int accountNumber,
    String currency,
    Double amount,
    String merchantName,
    String merchantLogo
)
{}
