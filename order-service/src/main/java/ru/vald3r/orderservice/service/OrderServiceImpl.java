package ru.vald3r.orderservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vald3r.orderservice.model.OrderDto;
import ru.vald3r.orderservice.model.OrderMapper;
import ru.vald3r.orderservice.repo.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public List<OrderDto> findCustomerOrders(final Long id) {
        return orderRepository.findAllByCustomerId(id)
                .stream()
                .map(orderMapper::orderToOrderDto)
                .collect(Collectors.toList());
    }
}
