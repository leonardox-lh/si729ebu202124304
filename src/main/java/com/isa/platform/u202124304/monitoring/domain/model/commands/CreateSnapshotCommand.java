package com.isa.platform.u202124304.inventory.domain.model.commands;

public record CreateSnapshotCommand(String snapshotId, String productSerialNumber, Double temperature, Double energy, Integer leakage) {
}
