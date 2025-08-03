package com.skydev.shopease.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.skydev.shopease.dto.request.CategoryRequestDTO;
import com.skydev.shopease.dto.response.CategoryResponseDTO;
import com.skydev.shopease.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryRequestDTO dto);
    CategoryResponseDTO toDto(Category entity);
    List<CategoryResponseDTO> toDto(List<Category> entities);
}
