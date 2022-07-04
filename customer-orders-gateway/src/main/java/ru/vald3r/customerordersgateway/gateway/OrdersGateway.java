package ru.vald3r.customerordersgateway.gateway;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;
import ru.vald3r.customerordersgateway.config.EndpointsConfig;
import ru.vald3r.customerordersgateway.model.OrderDto;

import java.util.List;
import java.util.logging.Level;

@Service
@RequiredArgsConstructor
public class OrdersGateway {
    private final WebClient webClient;
    private final EndpointsConfig endpointsConfig;

    public Mono<List<OrderDto>> getOrder(final Long id) {

        return webClient.get()
                .uri(endpointsConfig.getOrderService() + "{id}", id)
                .retrieve()
                .bodyToFlux(OrderDto.class)
                .collectList()
                .log(null, Level.INFO, SignalType.ON_NEXT, SignalType.ON_ERROR);
    }
}
