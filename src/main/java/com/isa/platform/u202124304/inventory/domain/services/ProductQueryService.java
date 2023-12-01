package com.isa.platform.u202124304.inventory.domain.services;

import com.isa.platform.u202124304.inventory.domain.model.aggregates.Product;
import com.isa.platform.u202124304.inventory.domain.model.queries.GetProductByIdQuery;

import java.util.Optional;

public interface ProductQueryService {
    Optional<Product> getProductById(GetProductByIdQuery id);
}
