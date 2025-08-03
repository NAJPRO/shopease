package com.skydev.shopease.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.skydev.shopease.dto.request.StockRequestDTO;
import com.skydev.shopease.dto.response.StockResponseDTO;
import com.skydev.shopease.entity.Stock;

@Mapper(componentModel = "spring")
public interface StockMapper {
    Stock toEntity(StockRequestDTO dto);
    StockResponseDTO tDto(Stock entity);
    List<StockResponseDTO> tDto(List<Stock> entities);
}
