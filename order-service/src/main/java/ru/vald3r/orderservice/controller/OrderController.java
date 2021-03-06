package ru.vald3r.orderservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vald3r.orderservice.model.OrderDto;
import ru.vald3r.orderservice.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders/")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<OrderDto> findCustomerOrders(final @RequestParam("client_id") Long clientId) {

        return orderService.findCustomerOrders(clientId);
    }
}
