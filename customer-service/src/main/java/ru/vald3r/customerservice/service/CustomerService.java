package ru.vald3r.customerservice.service;

import ru.vald3r.customerservice.model.CustomerDto;

public interface CustomerService {
    CustomerDto find(Long id);
}
