package ru.vald3r.customerordersgateway.gateway;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.vald3r.customerordersgateway.config.EndpointsConfig;
import ru.vald3r.customerordersgateway.model.ProductDto;

@Service
@RequiredArgsConstructor
public class ProductsGateway {
    private final WebClient webClient;
    private final EndpointsConfig endpointsConfig;

    public Mono<ProductDto> getProduct(final Long id) {

        return webClient.get()
                .uri(endpointsConfig.getProductService() + "{id}", id)
                .retrieve()
                .bodyToMono(ProductDto.class);
    }
}
