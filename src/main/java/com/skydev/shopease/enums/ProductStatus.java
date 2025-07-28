package com.skydev.shopease.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductStatus {
    DRAFT("Brouillon"),
    PUBLISHED("Publié"),
    OUT_OF_STOCK("En rupture"),
    ARCHIVED("Archivé"),
    UNAVAILABLE("Indisponible"),
    COMING_SOON("Bientôt disponible"),
    DELETED("Supprimé");

    private final String label;

}
