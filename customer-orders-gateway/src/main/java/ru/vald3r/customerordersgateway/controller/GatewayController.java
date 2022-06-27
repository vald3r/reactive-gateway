package ru.vald3r.customerordersgateway.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.vald3r.customerordersgateway.model.ResponseDto;
import ru.vald3r.customerordersgateway.service.GatewayService;

@RestController
@RequestMapping("/api/v1/orders/")
@RequiredArgsConstructor
@Slf4j
public class GatewayController {

    private final GatewayService gatewayService;

    @SneakyThrows
    @GetMapping("{client_id}")
    public Mono<ResponseDto> gateway(@PathVariable Long client_id) {

        return gatewayService.getOrdersByCustomerId(client_id);
    }
}
