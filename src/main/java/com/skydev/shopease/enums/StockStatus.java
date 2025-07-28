package com.skydev.shopease.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StockStatus {
    IN_STOCK("En stock"),
    LOW_STOCK("Stock faible"),
    OUT_OF_STOCK("Rupture de stock"),
    RESERVED("Réservé"),
    REPLENISHING("Réapprovisionnement en cours"),
    DISCONTINUED("Arrêté"),
    IN_TRANSIT("En transit");

    private final String label;
}
