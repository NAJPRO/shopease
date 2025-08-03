package com.skydev.shopease.dto.request;
import com.skydev.shopease.enums.StockStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockRequestDTO {
    private Long productId;

    private Integer quantity;
    
    private Integer threshold;

    private StockStatus status;
}
