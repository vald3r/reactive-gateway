package ru.vald3r.customerservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vald3r.customerservice.model.CustomerDto;
import ru.vald3r.customerservice.service.CustomerService;


@RestController
@RequestMapping("/api/v1/customers/")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/{id}")
    public CustomerDto find(final @PathVariable Long id) {
        return customerService.find(id);
    }
}
