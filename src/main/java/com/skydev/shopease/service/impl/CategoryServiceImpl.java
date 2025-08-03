package com.skydev.shopease.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skydev.shopease.dto.request.CategoryRequestDTO;
import com.skydev.shopease.dto.response.CategoryResponseDTO;
import com.skydev.shopease.entity.Category;
import com.skydev.shopease.enums.CategoryStatus;
import com.skydev.shopease.mapper.CategoryMapper;
import com.skydev.shopease.repository.CategoryRepository;
import com.skydev.shopease.service.CategoryService;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
@Getter
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;
    @Override
    public void delete(Long id) {
        this.categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryResponseDTO> findByStatus(CategoryStatus status) {
        return categoryMapper.toDto(categoryRepository.findByStatus(status));
    }

    @Override
    public List<CategoryResponseDTO> index() {
        return categoryMapper.toDto(categoryRepository.findAll());
    }

    @Override
    public CategoryResponseDTO show(Long id) {
        return categoryMapper.toDto(categoryRepository.findById(id).get());
    }

    @Override
    public CategoryResponseDTO store(CategoryRequestDTO dto) {
        Category category = categoryMapper.toEntity(dto);
        return categoryMapper.toDto(categoryRepository.save(category));
    }

    @Override
    public CategoryResponseDTO update(Long id, CategoryRequestDTO dto) {
        Category lasCategory = categoryRepository.findById(id).get();
        Category newCategory = categoryMapper.toEntity(dto);
        lasCategory.setName(newCategory.getName());
        lasCategory.setDescription(newCategory.getDescription());
        lasCategory.setStatus(newCategory.getStatus());

        categoryRepository.save(lasCategory);
        return categoryMapper.toDto(lasCategory);
    }

}
