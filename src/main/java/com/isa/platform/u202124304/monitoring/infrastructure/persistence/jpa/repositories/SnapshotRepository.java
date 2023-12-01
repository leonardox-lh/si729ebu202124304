package com.isa.platform.u202124304.monitoring.infrastructure.persistence.jpa.repositories;

import com.isa.platform.u202124304.monitoring.domain.model.entities.Snapshot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnapshotRepository extends JpaRepository<Snapshot, Long> {
}
