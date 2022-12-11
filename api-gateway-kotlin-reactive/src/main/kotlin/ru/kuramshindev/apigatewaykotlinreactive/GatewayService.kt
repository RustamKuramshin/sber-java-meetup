package ru.kuramshindev.apigatewaykotlinreactive

import ru.kuramshin.dto.apigateway.ApiGatewayDto
import java.util.*

interface GatewayService {
    suspend fun getContractById(uuid: UUID): ApiGatewayDto
}