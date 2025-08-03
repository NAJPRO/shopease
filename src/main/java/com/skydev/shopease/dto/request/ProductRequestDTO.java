package com.skydev.shopease.dto.request;

import java.math.BigDecimal;

import com.skydev.shopease.enums.ProductStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRequestDTO {
    private String title;
    private String picture;
    private Long category_id;
    private ProductStatus status;
    private BigDecimal price;
    private BigDecimal promotionalPrice;
    private String description;
}
