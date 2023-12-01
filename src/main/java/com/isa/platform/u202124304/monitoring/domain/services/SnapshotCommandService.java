package com.isa.platform.u202124304.inventory.domain.services;

import com.isa.platform.u202124304.inventory.domain.model.commands.CreateSnapshotCommand;

public interface SnapshotCommandService {
    Long createSnapshot(CreateSnapshotCommand command);
}
