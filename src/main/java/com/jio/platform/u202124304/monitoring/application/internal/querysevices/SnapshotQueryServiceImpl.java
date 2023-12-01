package com.jio.platform.u202124304.monitoring.application.internal.querysevices;

import com.jio.platform.u202124304.monitoring.domain.model.entities.Snapshot;
import com.jio.platform.u202124304.monitoring.domain.model.queries.GetSnapshotByIdQuery;
import com.jio.platform.u202124304.monitoring.domain.services.SnapshotQueryService;
import com.jio.platform.u202124304.monitoring.infrastructure.persistence.jpa.repositories.SnapshotRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SnapshotQueryServiceImpl implements SnapshotQueryService {

    private final SnapshotRepository snapshotRepository;

    public SnapshotQueryServiceImpl(SnapshotRepository snapshotRepository) {
        this.snapshotRepository = snapshotRepository;
    }

    @Override
    public Optional<Snapshot> getSnapshotById(GetSnapshotByIdQuery id) {
        return snapshotRepository.findById(id.idSnapshot());
    }
}
