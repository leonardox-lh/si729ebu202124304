package com.jio.platform.u202124304.inventory.domain.model.valueobjects;

import lombok.Getter;

public enum MonitoringLevel {

    ESSENTIAL_MONITORING(1),
    ADVANCE_MONITORING(2);

    private final int value;

    MonitoringLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MonitoringLevel fromValue(int value) {
        for (MonitoringLevel monitoringLevel : MonitoringLevel.values()) {
            if (monitoringLevel.value == value) {
                return monitoringLevel;
            }
        }
        throw new IllegalArgumentException("Invalid monitoring level value");
    }

}
