package com.jio.platform.u202124304.monitoring.interfaces.rest.resources;

public record CreateSnapshotResource(String snapshotId, String productSerialNumber, Double temperature, Double energy, Integer leakage) {
}
