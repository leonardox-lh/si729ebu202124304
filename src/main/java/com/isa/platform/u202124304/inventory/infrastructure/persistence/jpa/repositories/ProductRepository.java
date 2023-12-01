package com.isa.platform.u202124304.inventory.infrastructure.persistence.jpa.repositories;

import com.isa.platform.u202124304.inventory.domain.model.aggregates.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
