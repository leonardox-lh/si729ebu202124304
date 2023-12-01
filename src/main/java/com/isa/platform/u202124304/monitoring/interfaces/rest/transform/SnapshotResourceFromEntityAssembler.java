package com.isa.platform.u202124304.monitoring.interfaces.rest.transform;

import com.isa.platform.u202124304.monitoring.domain.model.entities.Snapshot;
import com.isa.platform.u202124304.monitoring.interfaces.rest.resources.SnapshotResource;

public class SnapshotResourceFromEntityAssembler {
    public static SnapshotResource toResourceFromEntity(Snapshot entity) {
        return new SnapshotResource(entity.getId(), entity.getSnapshotId(), entity.getProductSerialNumber(), entity.getTemperature(), entity.getEnergy(), entity.getLeakage());
    }
}
