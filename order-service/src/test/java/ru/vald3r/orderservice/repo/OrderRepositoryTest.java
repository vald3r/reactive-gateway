package ru.vald3r.orderservice.repo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ru.vald3r.orderservice.model.Order;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration-test")
class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;
    @Test
    void findAllByCustomerId() {
        List<Order> allByCustomerId = orderRepository.findAllByCustomerId(1L);
        assertEquals(3, allByCustomerId.size());
    }
}