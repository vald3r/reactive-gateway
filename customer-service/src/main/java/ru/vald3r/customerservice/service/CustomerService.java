package ru.vald3r.customerservice.service;

import ru.vald3r.customerservice.model.Customer;

import java.util.Optional;

public interface CustomerService {
    Optional<Customer> find(Long id);
}
