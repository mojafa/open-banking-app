package mojafa.betterbanking.repositories;

import java.util.Optional;

public interface MerchantDetailsRepository {
    Optional<String> findMerchantLogo(final String merchantName);
}
