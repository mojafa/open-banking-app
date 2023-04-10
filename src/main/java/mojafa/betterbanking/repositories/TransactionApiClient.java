package mojafa.betterbanking.repositories;

import mojafa.betterbanking.models.Transaction;

import java.util.List;

public interface TransactionApiClient {
    List<Transaction> findAllByAccountNumber(final Integer accountNumber);
}
