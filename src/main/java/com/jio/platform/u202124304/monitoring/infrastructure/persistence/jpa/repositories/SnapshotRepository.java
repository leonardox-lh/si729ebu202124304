package com.jio.platform.u202124304.monitoring.infrastructure.persistence.jpa.repositories;

import com.jio.platform.u202124304.monitoring.domain.model.entities.Snapshot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnapshotRepository extends JpaRepository<Snapshot, Long> {
    boolean existsBySnapshotId(String snapshotId);

    //crud basico


}
