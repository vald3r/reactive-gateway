package ru.vald3r.productService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vald3r.productService.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}