package ru.vald3r.productservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vald3r.productservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
