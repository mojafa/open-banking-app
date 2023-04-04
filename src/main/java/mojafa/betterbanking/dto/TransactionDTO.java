package com.mojafa.betterbanking.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDTO {
    private String type;
    private LocalDateTime date;
    private long accountNumber;
    private String currency;
    private int amount;
    private String merchantName;
    private String merchantLogo;
}