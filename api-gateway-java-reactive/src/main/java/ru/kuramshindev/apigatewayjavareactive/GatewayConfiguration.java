package ru.kuramshindev.apigatewayjavareactive;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class GatewayConfiguration {

    @Value("${upstreams.base-uri}")
    private String upstreamsBaseUri;

    @Bean
    public WebClient getWebClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder.baseUrl(upstreamsBaseUri).build();
    }

}
