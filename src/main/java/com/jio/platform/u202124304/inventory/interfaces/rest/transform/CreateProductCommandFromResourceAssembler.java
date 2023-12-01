package com.jio.platform.u202124304.inventory.interfaces.rest.transform;

import com.jio.platform.u202124304.inventory.domain.model.commands.CreateProductCommand;
import com.jio.platform.u202124304.inventory.interfaces.rest.resources.CreateProductResource;

public class CreateProductCommandFromResourceAssembler {
    public static CreateProductCommand toCommandFromResource(CreateProductResource resource) {
        return new CreateProductCommand(resource.brand(), resource.model(), resource.serialNumber(), resource.monitoringLevel());
    }
}
