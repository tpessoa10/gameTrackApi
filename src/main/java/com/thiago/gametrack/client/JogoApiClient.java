package com.thiago.gametrack.client;

import com.thiago.gametrack.dto.JogoApiResponse;
import com.thiago.gametrack.dto.JogoApiResponsePage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class JogoApiClient {

    private final RestClient restClient;
    private final String apiKey;

    public JogoApiClient(
            RestClient.Builder builder,
            @Value("${rawg.base-url}") String baseUrl,
            @Value("${rawg.api-key}") String apiKey
    ) {
        this.restClient = builder
                .baseUrl(baseUrl)
                .build();

        this.apiKey = apiKey;
    }

    public List<JogoApiResponse> buscarJogos(int pagina) {

        JogoApiResponsePage response =  restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/games")
                        .queryParam("key", apiKey)
                        .queryParam("page", pagina)
                        .queryParam("page_size", 20)
                        .build())
                .retrieve()
                .body(JogoApiResponsePage.class);

        return response.getResults();
    }
}