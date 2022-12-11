package ru.kuramshindev.apigatewayjava;

import ru.kuramshin.dto.apigateway.ApiGatewayDto;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public interface GatewayService {
    ApiGatewayDto getContractById(UUID uuid) throws ExecutionException, InterruptedException;
}
