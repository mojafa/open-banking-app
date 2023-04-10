package mojafa.betterbanking.repositories;

import org.springframework.beans.factory.annotation.Autowired;

public class RESTTransactionsAPIClient implements TransactionApiClient
@Autowired
public RESTTransactionsAPIClient(final WebClient webClient) {
    this.webClient = webClient;
}
        private final WebClient client;

}
