package com.jio.platform.u202124304.inventory.domain.model.commands;


public record CreateProductCommand(String brand, String model, String serialNumber, String monitoringLevel) {
}
