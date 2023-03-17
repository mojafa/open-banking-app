package com.mojafa.aninviolablecontract.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private LocalDateTime date;
    @Column(name = "account_number")
    private long accountNumber;
    private String currency;
    private int amount;
    @Column(name = "merchant_name")
    private String merchantName;
    @Column(name = "merchant_logo")
    private String merchantLogo;


}
