package com.jio.platform.u202124304.inventory.domain.model.aggregates;

import com.jio.platform.u202124304.inventory.domain.model.valueobjects.MonitoringLevel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

/**
 * Represents a Product.
 * The Product is an aggregate root
 */

@Getter
@Entity
public class Product /*extends AuditableModel*/ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The brand cannot be null")
    private String brand;

    @NotNull(message = "The model cannot be null")
    private String model;

    @NotNull(message = "The serial number cannot be null")
    private String serialNumber;

    /**
     * The MonitoringLevel for this Product
     */
    @Enumerated(EnumType.ORDINAL)
    @NotNull(message = "The monitoring level cannot be null")
    private MonitoringLevel monitoringLevel;

    public Product(String brand, String model, String serialNumber, MonitoringLevel monitoringLevel) {
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.monitoringLevel = monitoringLevel;
    }


    public Product() {

    }


}
