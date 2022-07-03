package ru.vald3r.orderservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vald3r.orderservice.model.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByCustomerId(Long customerId);
}