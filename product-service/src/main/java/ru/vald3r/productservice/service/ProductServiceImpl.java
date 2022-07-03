package ru.vald3r.productservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vald3r.productservice.model.ProductDto;
import ru.vald3r.productservice.model.ProductMapper;
import ru.vald3r.productservice.repo.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto find(final Long id) {
        return productRepository.findById(id)
                .map(productMapper::productToProductDto)
                .orElseThrow();
    }
}
