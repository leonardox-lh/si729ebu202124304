package com.jio.platform.u202124304.monitoring.interfaces.rest.transform;

import com.jio.platform.u202124304.monitoring.domain.model.commands.CreateSnapshotCommand;
import com.jio.platform.u202124304.monitoring.interfaces.rest.resources.CreateSnapshotResource;

public class CreateSnapshotCommandFromResourceAssembler {
    public static CreateSnapshotCommand toCommandFromResource(CreateSnapshotResource resource) {
        return new CreateSnapshotCommand(resource.snapshotId(), resource.productSerialNumber(), resource.temperature(), resource.energy(), resource.leakage());
    }
}
