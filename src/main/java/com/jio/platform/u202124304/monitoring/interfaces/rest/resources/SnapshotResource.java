package com.jio.platform.u202124304.monitoring.interfaces.rest.resources;

public record SnapshotResource(Long id,String snapshotId, String productSerialNumber, Double temperature, Double energy, Integer leakage) {
}
