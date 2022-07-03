package ru.vald3r.customerordersgateway.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import ru.vald3r.customerordersgateway.config.EndpointsConfig;
import ru.vald3r.customerordersgateway.model.*;
import ru.vald3r.customerordersgateway.service.GatewayService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebFluxTest(controllers = GatewayController.class)
@Import(EndpointsConfig.class)
class GatewayControllerTest {
    @Autowired
    WebTestClient webTestClient;
    @Autowired
    EndpointsConfig endpointsConfig;
    @MockBean
    GatewayService gatewayService;

    @Test
    void gatewayTest() {

        CustomerDto expectedCustomer = CustomerDto.builder()
                .id(1L)
                .name("Igor")
                .build();

        List<OrderDto> expectedOrders = new ArrayList<>() {{
            add(OrderDto.builder().id(1L).productId(1L).build());
            add(OrderDto.builder().id(3L).productId(1L).build());
            add(OrderDto.builder().id(4L).productId(2L).build());
        }};

        ProductDto expectedProductPC = ProductDto.builder().id(1L).title("PC").build();
        ProductDto expectedProductLaptop = ProductDto.builder().id(2L).title("Laptop").build();
        ProductDto expectedProductPhone = ProductDto.builder().id(3L).title("Phone").build();


        OrdersItem expectedOrdersItemPC1 = OrdersItem.builder()
                .productTitle(expectedProductPC.getTitle())
                .productId(expectedProductPC.getId())
                .id(expectedOrders.get(0).getId())
                .build();

        OrdersItem expectedOrdersItemPC3 = OrdersItem.builder()
                .productTitle(expectedProductPC.getTitle())
                .productId(expectedProductPC.getId())
                .id(expectedOrders.get(1).getId())
                .build();

        OrdersItem expectedOrdersItemLaptop = OrdersItem.builder()
                .productTitle(expectedProductLaptop.getTitle())
                .productId(expectedProductLaptop.getId())
                .id(expectedOrders.get(2).getId())
                .build();


        ResponseDto expectedResponse = ResponseDto.builder()
                .customerName(expectedCustomer.getName())
                .orders(List.of(expectedOrdersItemPC1, expectedOrdersItemPC3, expectedOrdersItemLaptop))
                .build();

        when(gatewayService.getOrdersByCustomerId(1L)).thenReturn(Mono.just(expectedResponse));

        webTestClient.get()
                .uri(endpointsConfig.getCustomerOrdersGateway() + "1")
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(ResponseDto.class)
                .isEqualTo(expectedResponse);
    }
}
