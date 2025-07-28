package com.skydev.shopease.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CategoryStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    ARCHIVED("Archived"),
    DELETED("Deleted"),
    PENDING("Pending approval");

    private final String status;

}
