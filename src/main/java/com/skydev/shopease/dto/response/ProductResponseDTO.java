package com.skydev.shopease.dto.response;

import java.math.BigDecimal;

import com.skydev.shopease.entity.Category;
import com.skydev.shopease.entity.Stock;
import com.skydev.shopease.entity.User;
import com.skydev.shopease.enums.ProductStatus;

public class ProductResponseDTO {

    private Long id;
    private String slug;
    private String title;
    private String picture;
    private ProductStatus status;
    private BigDecimal price;
    private BigDecimal promotionalPrice;
    private String description;
    private boolean isActive;
    private boolean isFeatured;

    private User user;
    private Category category;
    private Stock stock;
}
