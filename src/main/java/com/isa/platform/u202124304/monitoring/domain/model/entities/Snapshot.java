package com.isa.platform.u202124304.inventory.domain.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Snapshot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The snapshotId is mandatory")
    private String snapshotId;

    @NotNull(message = "The productSerialNumber is mandatory")
    private String productSerialNumber;

    @NotNull(message = "The temperature is mandatory")
    private Double temperature;

    private Double energy;

    @Min(value = 0, message = "The leakage must be 0 or 1")
    @Max(value = 1, message = "The leakage must be 0 or 1")
    private Integer leakage;

    public Snapshot(String snapshotId, String productSerialNumber, Double temperature, Double energy, Integer leakage) {
        this.snapshotId = snapshotId;
        this.productSerialNumber = productSerialNumber;
        this.temperature = temperature;
        this.energy = energy;
        this.leakage = leakage;
    }
    public Snapshot() {

    }
}