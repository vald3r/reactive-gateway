package ru.vald3r.productservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vald3r.productservice.model.Product;
import ru.vald3r.productservice.repo.ProductRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Optional<Product> find(final Long id) {
        return productRepository.findById(id);
    }
}
