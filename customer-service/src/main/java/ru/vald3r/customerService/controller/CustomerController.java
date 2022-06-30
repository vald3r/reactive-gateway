package ru.vald3r.customerService.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vald3r.customerService.model.CustomerDto;
import ru.vald3r.customerService.model.CustomerMapper;
import ru.vald3r.customerService.service.CustomerService;


@RestController
@RequestMapping("/api/v1/customers/")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @GetMapping("/{id}")
    public CustomerDto find(@PathVariable Long id){
        return customerService.find(id)
                .map(customerMapper::customerToCustomerDto)
                .orElseThrow();
    }
}
