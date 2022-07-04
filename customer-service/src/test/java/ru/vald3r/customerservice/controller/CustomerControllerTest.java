package ru.vald3r.customerservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import ru.vald3r.customerservice.model.CustomerDto;
import ru.vald3r.customerservice.service.CustomerService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration-test")
class CustomerControllerTest {

    @MockBean
    CustomerService customerService;
    @Autowired
    private CustomerController customerController;

    @Test
    void find() {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(1L).setName("Igor");
        when(customerService.find(1L)).thenReturn(customerDto);

        assertEquals(
                customerController.find(1L),
                customerDto
        );
    }
}