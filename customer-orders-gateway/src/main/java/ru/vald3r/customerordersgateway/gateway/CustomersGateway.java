package ru.vald3r.customerordersgateway.gateway;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;
import ru.vald3r.customerordersgateway.config.EndpointsConfig;
import ru.vald3r.customerordersgateway.model.CustomerDto;

import java.util.logging.Level;

@Service
@RequiredArgsConstructor
public class CustomersGateway {
    private final WebClient webClient;
    private final EndpointsConfig endpointsConfig;

    public Mono<CustomerDto> getCustomer(Long id) {

        return webClient.get()
                .uri(endpointsConfig.getCustomerService() + "{id}", id)
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(CustomerDto.class))
                .log(null, Level.INFO, SignalType.ON_NEXT, SignalType.ON_ERROR);
    }
}
