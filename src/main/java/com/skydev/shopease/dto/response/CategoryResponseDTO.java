package com.skydev.shopease.dto.response;

import com.skydev.shopease.enums.CategoryStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseDTO {
    private Long id;
    private String name;
    private String slug;
    private String description;
    private CategoryStatus status;
}
