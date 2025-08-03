package com.skydev.shopease.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRole {
    ADMIN("Administrateur"),
    CUSTOMER("Client");

    private final String label;

}
