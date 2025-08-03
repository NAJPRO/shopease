package com.skydev.shopease.dto.response;

import java.time.LocalDateTime;

import com.skydev.shopease.entity.Product;
import com.skydev.shopease.enums.StockStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockResponseDTO {

    private Long id;

    private Product product;

    private Integer quantity;
    
    private Integer threshold;

    private StockStatus status;

    private LocalDateTime updatedAt;
}
