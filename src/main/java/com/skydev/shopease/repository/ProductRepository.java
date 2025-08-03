package com.skydev.shopease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skydev.shopease.entity.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findById(Long id);

    void deleteById(Long id);

    List<Product> findByStock_QuantityGreaterThan(int quantity);

    List<Product> findByStock_QuantityLessThan(int quantity);

    List<Product> findByStock_QuantityBetween(int quantity1, int quantity2);

    List<Product> findByCategory_Id(Long categoryId);

    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

    List<Product> findByPromotionalPriceIsNotNull();

    List<Product> findByFeatured(boolean featured);

    @Query("SELECT p FROM Product p WHERE LOWER(p.slug) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Product> searchByKeyword(@Param("keyword") String keyword);
}
