package ru.vald3r.customerservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import ru.vald3r.customerservice.model.Customer;
import ru.vald3r.customerservice.model.CustomerDto;
import ru.vald3r.customerservice.model.CustomerMapperImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration-test")
class CustomerServiceImplTest {
    @Autowired
    private CustomerService customerService;
    @SpyBean
    private CustomerMapperImpl customerMapper;

    @Test
    void find() {
        Customer customerFromDb = new Customer();
        customerFromDb.setId(1L).setName("Igor");

        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(1L).setName("Igor");

        when(customerMapper.customerToCustomerDto(customerFromDb)).thenReturn(customerDto);

        assertEquals(
                customerDto,
                customerService.find(1L)
        );
    }

}