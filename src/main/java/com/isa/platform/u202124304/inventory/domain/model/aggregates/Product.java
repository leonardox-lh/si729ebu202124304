package com.isa.platform.u202124304.inventory.domain.model.entities;

import com.isa.platform.u202124304.inventory.domain.model.valueobjects.MonitoringLevel;
import com.isa.platform.u202124304.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
@Entity
public class Product extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The brand cannot be null")
    private String brand;

    @NotNull(message = "The model cannot be null")
    private String model;

    @NotNull(message = "The serial number cannot be null")
    private String serialNumber;

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
