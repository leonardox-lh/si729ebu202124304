package com.isa.platform.u202124304.inventory.application.internal.querysevices;

import com.isa.platform.u202124304.inventory.domain.model.aggregates.Product;
import com.isa.platform.u202124304.inventory.domain.model.queries.GetProductByIdQuery;
import com.isa.platform.u202124304.inventory.domain.services.ProductQueryService;
import com.isa.platform.u202124304.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;

import java.util.Optional;

public class ProductQueryServiceImpl implements ProductQueryService {
    private final ProductRepository productRepository;

    public ProductQueryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> getProductById(GetProductByIdQuery id) {
        return productRepository.findById(id.idProduct());
    }
}
