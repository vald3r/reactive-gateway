package ru.vald3r.customerService.service;

import ru.vald3r.customerService.model.Customer;

import java.util.Optional;

public interface CustomerService {
    Optional<Customer> find(Long id);
}
