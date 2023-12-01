package com.isa.platform.u202124304.inventory.domain.services;

import com.isa.platform.u202124304.inventory.domain.model.commands.CreateProductCommand;

public interface ProductCommandService {
    Long createProduct(CreateProductCommand command);
}
