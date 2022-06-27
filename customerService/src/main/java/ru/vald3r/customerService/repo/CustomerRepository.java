package ru.vald3r.customerService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vald3r.customerService.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}