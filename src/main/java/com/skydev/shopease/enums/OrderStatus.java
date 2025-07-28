package com.skydev.shopease.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    PENDING("En attente de paiement"),
    PAID("Payée"),
    PROCESSING("En cours de traitement"),
    SHIPPED("Expédiée"),
    DELIVERED("Livrée"),
    CANCELLED("Annulée"),
    REFUNDED("Remboursée"),
    FAILED("Échec de paiement"),
    RETURN_REQUESTED("Retour demandé"),
    RETURNED("Retour effectué"),
    PARTIALLY_DELIVERED("Partiellement livrée");

    private final String label;
}
