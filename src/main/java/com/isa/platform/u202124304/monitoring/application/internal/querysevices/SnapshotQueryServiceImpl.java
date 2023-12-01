package com.isa.platform.u202124304.inventory.application.internal.querysevices;

import com.isa.platform.u202124304.inventory.domain.model.entities.Snapshot;
import com.isa.platform.u202124304.inventory.domain.model.queries.GetSnapshotByIdQuery;
import com.isa.platform.u202124304.inventory.domain.services.SnapshotQueryService;
import com.isa.platform.u202124304.inventory.infrastructure.persistence.jpa.repositories.SnapshotRepository;

import java.util.Optional;

public class SnapshotQueryServiceImpl implements SnapshotQueryService {

    private final SnapshotRepository snapshotRepository;

    public SnapshotQueryServiceImpl(SnapshotRepository snapshotRepository) {
        this.snapshotRepository = snapshotRepository;
    }

    @Override
    public Optional<Snapshot> getSnapshotById(GetSnapshotByIdQuery id) {
        return Optional.empty();
    }
}
