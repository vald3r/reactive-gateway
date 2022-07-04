package ru.vald3r.productservice.service;

import ru.vald3r.productservice.model.ProductDto;

public interface ProductService {
    ProductDto find(Long id);
}
