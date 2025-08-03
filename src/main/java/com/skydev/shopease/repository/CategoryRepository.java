package com.skydev.shopease.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skydev.shopease.entity.Category;
import com.skydev.shopease.enums.CategoryStatus;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

    List<Category> findByStatus(CategoryStatus status);
}
