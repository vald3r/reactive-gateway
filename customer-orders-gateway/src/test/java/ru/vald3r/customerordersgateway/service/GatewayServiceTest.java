package ru.vald3r.customerordersgateway.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.vald3r.customerordersgateway.gateway.CustomersGateway;
import ru.vald3r.customerordersgateway.gateway.OrdersGateway;
import ru.vald3r.customerordersgateway.gateway.ProductsGateway;
import ru.vald3r.customerordersgateway.model.CustomerDto;
import ru.vald3r.customerordersgateway.model.OrderDto;
import ru.vald3r.customerordersgateway.model.OrdersItem;
import ru.vald3r.customerordersgateway.model.ProductDto;
import ru.vald3r.customerordersgateway.model.ResponseDto;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@SpringBootTest
class GatewayServiceTest {
    @Autowired
    GatewayService gatewayService;

    @MockBean
    CustomersGateway customersGateway;

    @MockBean
    OrdersGateway ordersGateway;

    @MockBean
    ProductsGateway productsGateway;

    @Test
    @DisplayName("Should get customer Igor by id=1")
    void get() {
        CustomerDto expectedCustomer = CustomerDto.builder()
                .id(1L)
                .name("Igor")
                .build();
        when(customersGateway.getCustomer(1L)).thenReturn(Mono.just(expectedCustomer));

        List<OrderDto> expectedOrders = new ArrayList<>() {{
            add(OrderDto.builder().id(1L).productId(1L).build());
            add(OrderDto.builder().id(3L).productId(1L).build());
            add(OrderDto.builder().id(4L).productId(2L).build());
        }};
        when(ordersGateway.getOrder(1L)).thenReturn(Mono.just(expectedOrders));

        ProductDto expectedProductPC = ProductDto.builder().id(1L).title("PC").build();
        when(productsGateway.getProduct(1L)).thenReturn(Mono.just(expectedProductPC));
        ProductDto expectedProductLaptop = ProductDto.builder().id(2L).title("Laptop").build();
        when(productsGateway.getProduct(2L)).thenReturn(Mono.just(expectedProductLaptop));
        ProductDto expectedProductPhone = ProductDto.builder().id(3L).title("Phone").build();
        when(productsGateway.getProduct(3L)).thenReturn(Mono.just(expectedProductPhone));

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

        /*
         {
         "orders": [
                 {
                     "productTitle": "PC",
                     "productId": 1,
                     "id": 1
                 },
                 {
                     "productTitle": "PC",
                     "productId": 1,
                     "id": 3
                 },
                 {
                     "productTitle": "Laptop",
                     "productId": 2,
                     "id": 4
                 }
             ],
         "customerName": "Igor"
         }
         */


        StepVerifier.create(gatewayService.getOrdersByCustomerId(1L).log())
                .expectNextMatches(responseDto ->
                        responseDto != null && responseDto.equals(expectedResponse))
                .expectComplete()
                .verify();
    }
}