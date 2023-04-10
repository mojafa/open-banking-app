package mojafa.betterbanking.services;

import mojafa.betterbanking.models.Transaction;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import mojafa.betterbanking.repositories.MerchantDetailsRepository;
import mojafa.betterbanking.repositories.TransactionApiClient;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TransactionService {
    public TransactionService(
            final TransactionApiClient transactionApiClient,
            final MerchantDetailsRepository merchantDetailsRepository) {
        this.transactionApiClient = transactionApiClient;
        this.merchantDetailsRepository = merchantDetailsRepository;
    }
    @CircuitBreaker(name="transactionService", fallbackMethod = "foundNone")
    public List<Transaction> findAllByAccountNumber(final Integer accountNumber) {
        var transactions = transactionApiClient.findAllByAccountNumber(accountNumber);
        transactions.forEach(transaction -> {
            merchantDetailsRepository
                    .findMerchantLogo(transaction.getMerchantName())
                    .ifPresent(logo ->
                            transaction.setMerchantLogo(logo)
                    );
        });
        return transactions;
    }


    public List<Transaction> foundNone(final Integer accountNumber, final Throwable t) {
        return Collections.emptyList();
    }


    private final TransactionApiClient transactionApiClient;
    private final MerchantDetailsRepository merchantDetailsRepository;
}



