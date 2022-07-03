package ru.vald3r.customerservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vald3r.customerservice.model.Customer;
import ru.vald3r.customerservice.repo.CustomerRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Optional<Customer> find(final Long id) {
        return customerRepository.findById(id);
    }
}
