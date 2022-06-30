package ru.vald3r.customerService.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.vald3r.customerService.model.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration-test")
class CustomerServiceImplTest {
    @Autowired
    private CustomerService customerService;

    @Test
    void find() {
        assertEquals(
                "Igor",
                customerService.find(1L)
                        .map(Customer::getName)
                        .orElse("")
        );
    }

}