package ru.vald3r.orderservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vald3r.orderservice.model.Order;
import ru.vald3r.orderservice.repo.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<Order> findCustomerOrders(final Long id) {
        return orderRepository.findAllByCustomerId(id);
    }
}
