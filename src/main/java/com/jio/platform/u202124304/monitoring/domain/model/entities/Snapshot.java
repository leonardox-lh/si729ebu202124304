package com.jio.platform.u202124304.monitoring.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
public class Snapshot {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @NotNull(message = "The snapshotId is mandatory")
    private String snapshotId;

    @Getter
    @NotNull(message = "The productSerialNumber is mandatory")
    private String productSerialNumber;

    @Getter
    @NotNull(message = "The temperature is mandatory")
    private Double temperature;

    @Getter
    @Column(nullable = true)
    private Double energy;

    @Getter
    @Column(nullable = true)
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