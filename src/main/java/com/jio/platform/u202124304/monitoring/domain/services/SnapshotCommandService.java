package com.jio.platform.u202124304.monitoring.domain.services;

import com.jio.platform.u202124304.monitoring.domain.model.commands.CreateSnapshotCommand;

public interface SnapshotCommandService {
    Long createSnapshot(CreateSnapshotCommand command);

}
