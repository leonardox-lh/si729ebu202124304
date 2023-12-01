package com.jio.platform.u202124304.inventory.infrastructure.persistence.jpa.repositories;

import com.jio.platform.u202124304.inventory.domain.model.aggregates.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsBySerialNumber(String s);

    Product findBySerialNumber(String s);
}
