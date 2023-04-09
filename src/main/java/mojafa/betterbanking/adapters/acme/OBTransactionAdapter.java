package mojafa.betterbanking.adapters.acme;

import com.acme.banking.model.OBTransaction6;
import com.mojafa.betterbanking.models.Transaction;

import java.util.Optional;
import java.util.function.Function;
import java.util.Date;

public class OBTransactionAdapter {
    public com.mojafa.betterbanking.models.Transaction adapt(final OBTransaction6 transaction6){
        return transactionFunction.apply(transaction6);
    }
    private final Function<OBTransaction6, com.mojafa.betterbanking.models.Transaction> transactionFunction = obTransaction6 ->{
        var t = new Transaction();
        t.setAccountNumber(Integer.valueOf(obTransaction6.getAccountId()));
        var amount = tryAndApply(obTransaction6, o -> Double.valueOf(o.getAmount().getAmount()));
        var fx = tryAndApply(obTransaction6, o -> o.getCurrencyExchange().getExchangeRate().doubleValue());
        t.setAmount((int) (amount.orElse(0.0) * fx.orElse(1.0)));

        tryAndApply(obTransaction6, o -> obTransaction6.getCurrencyExchange().getUnitCurrency())
                .ifPresent(t::setCurrency);
        tryAndApply(obTransaction6, o -> obTransaction6.getCreditDebitIndicator().toString())
                .ifPresent(t::setType);
        tryAndApply(obTransaction6, o -> obTransaction6.getMerchantDetails().getMerchantName())
                .ifPresent(t::setMerchantName);
        tryAndApply(obTransaction6, o -> new Date(obTransaction6.getValueDateTime().toDate().toEpochDay()))
                .ifPresent(t::setDate);
        return t;
    };
    private <T> Optional<T> tryAndApply(final OBTransaction6 transaction6, Function<OBTransaction6, T> func) {
        try {
            return Optional.of(func.apply(transaction6));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }
}
