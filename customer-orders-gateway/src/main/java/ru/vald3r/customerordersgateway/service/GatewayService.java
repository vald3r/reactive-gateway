package ru.vald3r.customerordersgateway.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;
import reactor.util.function.Tuple2;
import ru.vald3r.customerordersgateway.gateway.CustomersGateway;
import ru.vald3r.customerordersgateway.gateway.OrdersGateway;
import ru.vald3r.customerordersgateway.gateway.ProductsGateway;
import ru.vald3r.customerordersgateway.model.CustomerDto;
import ru.vald3r.customerordersgateway.model.OrderDto;
import ru.vald3r.customerordersgateway.model.OrdersItem;
import ru.vald3r.customerordersgateway.model.ResponseDto;

import java.util.List;
import java.util.logging.Level;


@Service
@RequiredArgsConstructor
@Slf4j
public class GatewayService {
    private final OrdersGateway ordersGateway;
    private final ProductsGateway productsGateway;
    private final CustomersGateway customersGateway;

    public Mono<ResponseDto> getOrdersByCustomerId(final Long id) {
        Mono<List<OrderDto>> orders = ordersGateway.getOrder(id);
        Mono<CustomerDto> customer = customersGateway.getCustomer(id);

        Mono<String> customerName = customer
                .map(CustomerDto::getName);

        Mono<List<OrdersItem>> ordersList = orders.flatMap(
                orderDtoList -> Flux.fromStream(orderDtoList.stream())
                        .flatMap(this::orderDtoToOrderItem)
                        .log(null, Level.INFO, SignalType.ON_NEXT, SignalType.ON_ERROR)
                        .collectList()
        );

        Mono<Tuple2<List<OrdersItem>, String>> combined = ordersList.zipWith(customerName);

        return combined.log(null, Level.INFO, SignalType.ON_NEXT, SignalType.ON_ERROR)
                .map(
                        result -> ResponseDto.builder()
                                .orders(result.getT1())
                                .customerName(result.getT2())
                                .build()
                );
    }

    private Mono<OrdersItem> orderDtoToOrderItem(final OrderDto orderDto) {
        return productsGateway.getProduct(orderDto.getProductId())
                .map(productDto -> OrdersItem
                        .builder()
                        .id(orderDto.getId())
                        .productId(orderDto.getProductId())
                        .productTitle(productDto.getTitle())
                        .build()
                );
    }
}
