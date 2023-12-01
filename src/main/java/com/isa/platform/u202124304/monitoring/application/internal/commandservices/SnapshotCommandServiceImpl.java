package com.isa.platform.u202124304.monitoring.application.internal.commandservices;

import com.isa.platform.u202124304.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import com.isa.platform.u202124304.monitoring.domain.model.commands.CreateSnapshotCommand;
import com.isa.platform.u202124304.monitoring.domain.model.entities.Snapshot;
import com.isa.platform.u202124304.monitoring.domain.services.SnapshotCommandService;
import com.isa.platform.u202124304.monitoring.infrastructure.persistence.jpa.repositories.SnapshotRepository;
import org.springframework.stereotype.Service;

@Service
public class SnapshotCommandServiceImpl implements SnapshotCommandService {

    private final SnapshotRepository snapshotRepository;
    private final ProductRepository productRepository;

    public SnapshotCommandServiceImpl(SnapshotRepository snapshotRepository, ProductRepository productRepository) {
        this.snapshotRepository = snapshotRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Long createSnapshot(CreateSnapshotCommand command) {
        if (!productRepository.existsBySerialNumber(command.productSerialNumber())) {
            throw new IllegalArgumentException("Product with same serial number does not exist");
        }
        if (snapshotRepository.existsBySnapshotId(command.snapshotId())) {
            throw new IllegalArgumentException("Snapshot with same id already exists");
        }

        Snapshot snapshot= new Snapshot(command.snapshotId(), command.productSerialNumber(), command.temperature(), command.energy(), command.leakage());
        snapshotRepository.save(snapshot);
        return snapshot.getId();
    }
}
