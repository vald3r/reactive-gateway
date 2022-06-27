package ru.vald3r.productService.service;

import ru.vald3r.productService.model.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Product> find(Long id);
}
