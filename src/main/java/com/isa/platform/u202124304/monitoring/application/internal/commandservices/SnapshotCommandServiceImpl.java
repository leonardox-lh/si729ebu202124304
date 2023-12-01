package com.isa.platform.u202124304.inventory.application.internal.commandservices;

import com.isa.platform.u202124304.inventory.domain.model.commands.CreateSnapshotCommand;
import com.isa.platform.u202124304.inventory.domain.services.SnapshotCommandService;
import com.isa.platform.u202124304.inventory.infrastructure.persistence.jpa.repositories.SnapshotRepository;

public class SnapshotCommandServiceImpl implements SnapshotCommandService {

    private final SnapshotRepository snapshotRepository;

    public SnapshotCommandServiceImpl(SnapshotRepository snapshotRepository) {
        this.snapshotRepository = snapshotRepository;
    }

    @Override
    public Long createSnapshot(CreateSnapshotCommand command) {
        return null;
    }
}
