package com.jio.platform.u202124304.inventory.interfaces.rest.resources;

import com.jio.platform.u202124304.inventory.domain.model.valueobjects.MonitoringLevel;

public record ProductResource(Long id, String brand, String model, String serialNumber, MonitoringLevel monitoringLevel) {
}
