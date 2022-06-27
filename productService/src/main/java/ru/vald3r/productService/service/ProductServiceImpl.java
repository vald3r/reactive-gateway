package ru.vald3r.productService.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vald3r.productService.model.Product;
import ru.vald3r.productService.repo.ProductRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Optional<Product> find(Long id){
        return productRepository.findById(id);
    }
}
