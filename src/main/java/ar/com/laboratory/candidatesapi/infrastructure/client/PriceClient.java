package ar.com.laboratory.candidatesapi.infrastructure.client;

import ar.com.laboratory.candidatesapi.domain.DolarResponse;
import ar.com.laboratory.candidatesapi.infrastructure.exceptions.DolarClientException;
import ar.com.laboratory.candidatesapi.infrastructure.exceptions.MaxRetriesException;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.util.retry.Retry;

@Server
public class PriceClient {


    private final WebClient webClient;

    public PriceClient(@Value("${dolar.price.host}") String percentageUrl) {
        this.webClient = WebClient.create(percentageUrl);
    }

public DolarResponse getPriceDolar() {
    return webClient.get()
            .uri("/v1/dolares/blue")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(DolarResponse.class)
            .retryWhen(Retry.max(3).onRetryExhaustedThrow((retryBackoffSpec, retrySignal) -> new MaxRetriesException("Maximum number of retries exceeded.")))
            .onErrorMap(e -> new DolarClientException("Error while fetching dolar price.", e.getMessage()))
            .block();
}

}
