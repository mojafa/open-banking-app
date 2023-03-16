package com.mojafa.aninviolablecontract.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Type type;
    private Integer accountNumber
    private String currency;
    private Double amount;
    private String merchantName;
    private String merchantLogo;


    public enum Type {
        DEBIT,
        CREDIT
    }

}
