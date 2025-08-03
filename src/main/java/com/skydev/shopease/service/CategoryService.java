package com.skydev.shopease.service;

import java.util.List;

import com.skydev.shopease.dto.request.CategoryRequestDTO;
import com.skydev.shopease.dto.response.CategoryResponseDTO;
import com.skydev.shopease.enums.CategoryStatus;

public interface CategoryService {
    CategoryResponseDTO store(CategoryRequestDTO dto);
    CategoryResponseDTO update(Long id, CategoryRequestDTO dto);
    CategoryResponseDTO show(Long id);

    void delete(Long id);
    List<CategoryResponseDTO> index();
    List<CategoryResponseDTO> findByStatus(CategoryStatus status);

}
