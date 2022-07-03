package ru.vald3r.customerservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vald3r.customerservice.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
