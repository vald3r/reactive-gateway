package ru.vald3r.ordersService.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vald3r.ordersService.model.OrderDto;
import ru.vald3r.ordersService.model.OrderMapper;
import ru.vald3r.ordersService.service.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders/")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping("/{client_id}")
    public List<OrderDto> findCustomerOrders(@PathVariable Long client_id){

        return orderService
                .findCustomerOrders(client_id)
                .stream()
                .map(orderMapper::orderToOrderDto)
                .collect(Collectors.toList());
    }
}
