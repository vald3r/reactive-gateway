package ru.vald3r.orderservice.service;

import ru.vald3r.orderservice.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> findCustomerOrders(Long id);
}
