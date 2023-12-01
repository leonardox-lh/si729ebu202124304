package com.jio.platform.u202124304.inventory.interfaces.rest.transform;

import com.jio.platform.u202124304.inventory.domain.model.aggregates.Product;
import com.jio.platform.u202124304.inventory.interfaces.rest.resources.ProductResource;

public class ProductResourceFromEntityAssembler {
    public static ProductResource toResourceFromEntity(Product entity) {
        return new ProductResource(entity.getId(), entity.getBrand(), entity.getModel(), entity.getSerialNumber(), entity.getMonitoringLevel());
    }
}
