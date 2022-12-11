package ru.kuramshindev.apigatewaykotlinreactive

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class GatewayConfiguration(
    @Value("\${upstreams.base-uri}")
    private val upstreamsBaseUri: String
) {

    @Bean
    fun getWebClient(webClientBuilder: WebClient.Builder): WebClient =
        webClientBuilder.baseUrl(upstreamsBaseUri).build()
}