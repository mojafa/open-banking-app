package com.mojafa.betterbanking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private Date date;
    @Column(name = "account_number")
    private long accountNumber;
    private String currency;
    private int amount;
    @Column(name = "merchant_name")
    private String merchantName;
    @Column(name = "merchant_logo")
    private String merchantLogo;
}
