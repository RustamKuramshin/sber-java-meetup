package ru.kuramshindev.apigatewaykotlinreactive

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import ru.kuramshin.dto.apigateway.ApiGatewayDto
import java.util.*
import kotlin.system.measureTimeMillis

@RestController("gateway-controller")
@RequestMapping(value = ["/api/v1"])
class GatewayController(
    private val gatewayService: GatewayService
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @RequestMapping(method = [RequestMethod.GET], value = ["/contracts/{uuid}"])
    @ResponseStatus(HttpStatus.OK)
    suspend fun getContractById(@PathVariable("uuid") uuid: UUID): ApiGatewayDto {
        var apiGatewayDto: ApiGatewayDto
        val elapsed = measureTimeMillis {
            apiGatewayDto = gatewayService.getContractById(uuid)
        }
        log.info("Elapsed time: $elapsed")
        return apiGatewayDto
    }
}