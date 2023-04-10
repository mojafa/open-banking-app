package mojafa.betterbanking.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionDTO {
    private String type;
    private Date date;
    private Integer accountNumber;
    private String currency;
    private Double amount;
    private String merchantName;
    private String merchantLogo;
}