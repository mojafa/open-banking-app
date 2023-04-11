package mojafa.betterbanking.dto;

import lombok.Builder;
import lombok.Data;
import mojafa.betterbanking.models.Transaction;

import java.util.Date;


@Data
@Builder
public class TransactionDTO {
    private Long id;
    private String type;
    private Date date;
    private Integer accountNumber;
    private String currency;
    private Double amount;
    private String merchantName;
    private String merchantLogo;

    public static TransactionDTO apply(final Transaction tr) {
        var t = new TransactionDTOBuilder()
                .id(tr.getId())
                .type(tr.getType())
                .accountNumber(tr.getAccountNumber())
                .currency(tr.getCurrency())
                .amount(tr.getAmount())
                .merchantName(tr.getMerchantName())
                .merchantLogo(tr.getMerchantLogo())
                .build();
        return t;
    }
}
