package ru.vald3r.productservice.service;

import ru.vald3r.productservice.model.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Product> find(Long id);
}
