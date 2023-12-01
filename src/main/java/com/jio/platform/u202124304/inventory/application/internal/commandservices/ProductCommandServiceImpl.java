package com.jio.platform.u202124304.inventory.application.internal.commandservices;

import com.jio.platform.u202124304.inventory.domain.model.aggregates.Product;
import com.jio.platform.u202124304.inventory.domain.model.commands.CreateProductCommand;
import com.jio.platform.u202124304.inventory.domain.model.valueobjects.MonitoringLevel;
import com.jio.platform.u202124304.inventory.domain.services.ProductCommandService;
import com.jio.platform.u202124304.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {

    private final ProductRepository productRepository;

    public ProductCommandServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Long createProduct(CreateProductCommand command) {
        if (productRepository.existsBySerialNumber(command.serialNumber())) {
            throw new IllegalArgumentException("Product with same serial number already exists");
        }
        MonitoringLevel monitoringLevel = null;
        if (Objects.equals(command.monitoringLevel(), "ESSENTIAL_MONITORING")) {
            monitoringLevel= MonitoringLevel.ESSENTIAL_MONITORING;
        }
        else if (Objects.equals(command.monitoringLevel(), "ADVANCE_MONITORING")) {
            monitoringLevel= MonitoringLevel.ADVANCE_MONITORING;
        }
        else {
            throw new IllegalArgumentException("Monitoring level is not valid");
        }
        Product product = new Product(command.brand(), command.model(), command.serialNumber(), monitoringLevel);
        productRepository.save(product);
        return product.getId();
    }
}
