package ru.kuramshindev.apigatewayjava;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.kuramshin.dto.apigateway.ApiGatewayDto;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController("gateway-controller")
@RequestMapping(value = "/api/v1")
public class GatewayController {

    private final GatewayService gatewayService;

    @RequestMapping(method = RequestMethod.GET, value = "/contracts/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public ApiGatewayDto getContractById(@PathVariable("uuid") UUID uuid) throws Exception {
        return gatewayService.getContractById(uuid);
    }
}