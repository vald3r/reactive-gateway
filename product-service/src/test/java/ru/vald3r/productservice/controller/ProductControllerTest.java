package ru.vald3r.productservice.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import ru.vald3r.productservice.model.ProductDto;
import ru.vald3r.productservice.service.ProductService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration-test")
class ProductControllerTest {
    @Autowired
    ProductController productController;
    @MockBean
    private ProductService productService;


    @Test
    void find() {
        ProductDto productDto = new ProductDto();
        productDto.setId(1L).setTitle("PC");
        Mockito.when(productService.find(1L)).thenReturn(productDto);

        assertEquals(
                productController.find(1L),
                productDto
        );
    }
}