package ru.kuramshindev.apigatewayjavareactive;

import reactor.core.publisher.Mono;
import ru.kuramshin.dto.apigateway.ApiGatewayDto;

import java.util.UUID;

public interface GatewayService {
    Mono<ApiGatewayDto> getContractById(UUID uuid);
}
