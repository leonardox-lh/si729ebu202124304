package com.isa.platform.u202124304.inventory.application.internal.commandservices;

import com.isa.platform.u202124304.inventory.domain.model.commands.CreateProductCommand;
import com.isa.platform.u202124304.inventory.domain.services.ProductCommandService;
import com.isa.platform.u202124304.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;

public class ProductCommandServiceImpl implements ProductCommandService {

    private final ProductRepository productRepository;

    public ProductCommandServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Long createProduct(CreateProductCommand command) {
        return null;
    }
}
