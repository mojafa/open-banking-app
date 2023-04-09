package mojafa.betterbanking.repositories;

import java.util.List;

public interface TransactionApiClient {
    List<com.mojafa.betterbanking.models.Transaction> findAllByAccountNumber(Long accountNumber);
}
