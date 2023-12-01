package com.jio.platform.u202124304.monitoring.application.internal.commandservices;

import com.jio.platform.u202124304.inventory.domain.model.aggregates.Product;
import com.jio.platform.u202124304.inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import com.jio.platform.u202124304.monitoring.domain.model.commands.CreateSnapshotCommand;
import com.jio.platform.u202124304.monitoring.domain.model.entities.Snapshot;
import com.jio.platform.u202124304.monitoring.domain.services.SnapshotCommandService;
import com.jio.platform.u202124304.monitoring.infrastructure.persistence.jpa.repositories.SnapshotRepository;
import org.springframework.stereotype.Service;
import com.jio.platform.u202124304.inventory.domain.model.valueobjects.MonitoringLevel;

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
        Product product=productRepository.findBySerialNumber(command.productSerialNumber());
        if(command.energy()!=null||command.leakage()!=null){

            if (product.getMonitoringLevel()==MonitoringLevel.ESSENTIAL_MONITORING)
                throw new IllegalArgumentException("Snapshot Data not compatible with product current Monitoring Level");
        }

        if(product.getMonitoringLevel()==MonitoringLevel.ADVANCE_MONITORING){
            if(command.energy()==null||command.leakage()==null)
                throw new IllegalArgumentException("Energy and leakage data need to be added for Advance Monitoring");
        }
        snapshotRepository.save(snapshot);
        return snapshot.getId();
    }
}
