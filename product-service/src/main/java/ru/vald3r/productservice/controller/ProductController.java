package ru.vald3r.productservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vald3r.productservice.model.ProductDto;
import ru.vald3r.productservice.service.ProductService;


@RestController
@RequestMapping("/api/v1/products/")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public ProductDto find(final @PathVariable Long id) {
        return productService.find(id);
    }
}
