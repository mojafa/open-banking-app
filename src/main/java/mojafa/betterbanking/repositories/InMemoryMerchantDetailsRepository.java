package mojafa.betterbanking.repositories;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InMemoryMerchantDetailsRepository implements MerchantDetailsRepository {

    @Override
    public Optional<String> findMerchantLogo(String merchantName) {
        if (merchantName == null) {
            return Optional.empty();
        }
        return Optional.of(merchantName + ".png");
    }
}
