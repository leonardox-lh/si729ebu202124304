package com.isa.platform.u202124304.inventory.domain.services;


import com.isa.platform.u202124304.inventory.domain.model.entities.Snapshot;
import com.isa.platform.u202124304.inventory.domain.model.queries.GetSnapshotByIdQuery;

import java.util.Optional;

public interface SnapshotQueryService {
    Optional<Snapshot> getSnapshotById(GetSnapshotByIdQuery id);
}
