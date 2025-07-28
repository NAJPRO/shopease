package com.skydev.shopease.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentStatus {
    PENDING("En attente"),
    COMPLETED("Payée"),
    FAILED("Échouée"),
    CANCELLED("Annulée"),
    REFUNDED("Remboursée");

    private final String label;
}
