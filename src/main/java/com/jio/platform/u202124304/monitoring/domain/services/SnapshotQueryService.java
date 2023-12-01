package com.jio.platform.u202124304.monitoring.domain.services;


import com.jio.platform.u202124304.monitoring.domain.model.entities.Snapshot;
import com.jio.platform.u202124304.monitoring.domain.model.queries.GetSnapshotByIdQuery;

import java.util.Optional;

public interface SnapshotQueryService {
    Optional<Snapshot> getSnapshotById(GetSnapshotByIdQuery id);
}
