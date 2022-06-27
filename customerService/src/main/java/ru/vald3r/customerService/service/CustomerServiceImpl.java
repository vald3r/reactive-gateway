package ru.vald3r.customerService.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vald3r.customerService.model.Customer;
import ru.vald3r.customerService.repo.CustomerRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Optional<Customer> find(Long id){
        return customerRepository.findById(id);
    }
}
