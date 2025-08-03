package com.skydev.shopease.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.skydev.shopease.dto.request.ProductRequestDTO;
import com.skydev.shopease.dto.response.ProductResponseDTO;
import com.skydev.shopease.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductRequestDTO dto);
    ProductResponseDTO toDto(Product entity);
    List<ProductResponseDTO> toDto(List<Product> entities);
}
