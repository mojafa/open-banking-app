package mojafa.betterbanking.services;

import lombok.extern.slf4j.Slf4j;
import mojafa.betterbanking.models.Transaction;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import mojafa.betterbanking.repositories.MerchantDetailsRepository;
import mojafa.betterbanking.repositories.TransactionApiClient;
import mojafa.betterbanking.repositories.TransactionRepository;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TransactionService {
    public TransactionService(
            final TransactionApiClient transactionApiClient,
            final MerchantDetailsRepository merchantDetailsRepository,
            final TransactionRepository transactionRepository) {
        this.transactionApiClient = transactionApiClient;
        this.merchantDetailsRepository = merchantDetailsRepository;
        this.transactionRepository = transactionRepository;
    }

    @PostFilter(value = "hasAuthority(filterObject.accountNumber)")
    @CircuitBreaker(name="transactionService", fallbackMethod = "findAllByAccountNumber")
    public List<Transaction> findAllByAccountNumber(final Integer accountNumber) throws Exception{
        var transactions = transactionApiClient.findAllByAccountNumber(accountNumber);
        transactions.forEach(transaction ->
            merchantDetailsRepository
                    .findMerchantLogo(transaction.getMerchantName())
                    .ifPresent(transaction::setMerchantLogo)
            );
            return transactions;
        }


    private List<Transaction> findAllByAccountNumber(final Integer accountNumber, final Throwable t) {
        log.info("falling back to database to get transactions");
        return transactionRepository.findAllByAccountNumber(accountNumber);
    }


    private final TransactionApiClient transactionApiClient;
    private final MerchantDetailsRepository merchantDetailsRepository;
    private final TransactionRepository transactionRepository;
}



