package ru.vald3r.productservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.vald3r.productservice.model.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration-test")
class ProductServiceTest {


    @Autowired
    private ProductService productService;

    @Test
    void find() {
        assertEquals(
                "PC",
                productService.find(1L)
                        .map(Product::getTitle)
                        .orElse("")
        );
    }
}