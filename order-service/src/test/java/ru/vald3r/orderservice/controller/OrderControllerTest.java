package ru.vald3r.orderservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import ru.vald3r.orderservice.model.OrderDto;
import ru.vald3r.orderservice.service.OrderService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration-test")
class OrderControllerTest {

    @Autowired
    private OrderController orderController;

    @MockBean
    private OrderService orderService;

    @Test
    void findCustomerOrders() {
        OrderDto orderDto1 = new OrderDto();
        orderDto1.setId(1L).setProductId(1L);
        OrderDto orderDto2 = new OrderDto();
        orderDto1.setId(3L).setProductId(1L);
        OrderDto orderDto3 = new OrderDto();
        orderDto1.setId(4L).setProductId(2L);

        List<OrderDto> expectedOrders = List.of(orderDto1,
                orderDto2,
                orderDto3
        );

        when(orderService.findCustomerOrders(1L))
                .thenReturn(expectedOrders);

        assertEquals(
                orderController.findCustomerOrders(1L),
                expectedOrders
        );

    }
}