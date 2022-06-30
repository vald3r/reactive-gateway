package ru.vald3r.ordersService.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vald3r.ordersService.model.Order;
import ru.vald3r.ordersService.repo.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<Order> findCustomerOrders(Long id){
        return orderRepository.findAllByCustomerId(id);
    }
}
