package com.isa.platform.u202124304.inventory.domain.model.commands;

import com.isa.platform.u202124304.inventory.domain.model.valueobjects.MonitoringLevel;

public record CreateProductCommand(String brand, String model, String serialNumber, MonitoringLevel monitoringLevel) {
}
