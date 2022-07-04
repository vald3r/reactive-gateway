package ru.vald3r.productservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import ru.vald3r.productservice.model.Product;
import ru.vald3r.productservice.model.ProductDto;
import ru.vald3r.productservice.model.ProductMapperImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration-test")
class ProductServiceTest {


    @SpyBean
    ProductMapperImpl productMapper;
    @Autowired
    private ProductService productService;

    @Test
    void find() {
        Product product = new Product();
        product.setId(1L).setTitle("PC");

        ProductDto productDto = new ProductDto();
        productDto.setId(1L).setTitle("PC");

        when(productMapper.productToProductDto(product)).thenReturn(productDto);

        assertEquals(
                productDto,
                productService.find(1L)
        );
    }
}