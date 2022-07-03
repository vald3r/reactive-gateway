package ru.vald3r.orderservice.service;

import ru.vald3r.orderservice.model.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> findCustomerOrders(Long id);
}
