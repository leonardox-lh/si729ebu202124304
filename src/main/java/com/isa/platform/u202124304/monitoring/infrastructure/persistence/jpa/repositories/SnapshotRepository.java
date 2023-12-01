package com.isa.platform.u202124304.inventory.infrastructure.persistence.jpa.repositories;

import com.isa.platform.u202124304.inventory.domain.model.entities.Snapshot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnapshotRepository extends JpaRepository<Snapshot, Long> {
}
