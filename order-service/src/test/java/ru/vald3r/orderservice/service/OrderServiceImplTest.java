package ru.vald3r.orderservice.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import ru.vald3r.orderservice.model.Order;
import ru.vald3r.orderservice.model.OrderDto;
import ru.vald3r.orderservice.model.OrderMapperImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration-test")
class OrderServiceImplTest {
    @Autowired
    private OrderService orderService;

    @SpyBean
    private OrderMapperImpl orderMapper;

    @Test
    void findCustomerOrders() {
        Order order1 = new Order();
        order1.setId(1L).setProductId(1L);
        Order order2 = new Order();
        order2.setId(3L).setProductId(1L);
        Order order3 = new Order();
        order3.setId(4L).setProductId(2L);

        List<Order> expectedOrders = List.of(order1,
                order2,
                order3
        );


        OrderDto orderDto1 = new OrderDto();
        orderDto1.setId(1L).setProductId(1L);
        OrderDto orderDto2 = new OrderDto();
        orderDto1.setId(3L).setProductId(1L);
        OrderDto orderDto3 = new OrderDto();
        orderDto1.setId(4L).setProductId(2L);

        List<OrderDto> expectedOrdersDTOs = List.of(orderDto1,
                orderDto2,
                orderDto3
        );

        for (int i = 0; i < expectedOrders.size(); i++) {
            Mockito.when(orderMapper
                            .orderToOrderDto(expectedOrders.get(i)))
                    .thenReturn(expectedOrdersDTOs.get(i));
        }


        assertIterableEquals(
                expectedOrdersDTOs,
                orderService.findCustomerOrders(1L)
        );

    }
}