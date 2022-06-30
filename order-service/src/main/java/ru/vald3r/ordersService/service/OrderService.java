package ru.vald3r.ordersService.service;

import ru.vald3r.ordersService.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> findCustomerOrders(Long id);
}
