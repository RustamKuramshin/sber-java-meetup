package ru.kuramshindev.apigatewayjavareactive;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
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
    public Mono<ApiGatewayDto> getContractById(@PathVariable("uuid") UUID uuid) {
        return gatewayService.getContractById(uuid)
                .elapsed()
                .doOnNext(tuple -> log.info("Elapsed time: {}", tuple.getT1()))
                .map(Tuple2::getT2);
    }
}
