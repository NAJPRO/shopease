package com.skydev.shopease.service;

import java.math.BigDecimal;
import java.util.List;

import com.skydev.shopease.dto.request.ProductRequestDTO;
import com.skydev.shopease.dto.response.ProductResponseDTO;

public interface ProductService {
    ProductResponseDTO create(ProductRequestDTO dto);
    ProductResponseDTO getProductById(Long id);
    ProductResponseDTO update(Long id, ProductRequestDTO dto);
    List<ProductResponseDTO> getAllProducts(); 
    void delete(Long id);

    List<ProductResponseDTO> sarchProducts(String keyString);
    List<ProductResponseDTO> filterProductByCategory(Long categoryId);
    List<ProductResponseDTO> filterProductsByPriceRange(BigDecimal min, BigDecimal max);

    List<ProductResponseDTO> filterByStockAvailability(boolean inStock);
    // List<ProductResponseDTO> getTopSellingProducts(); 
    // List<ProductResponseDTO> getNewArrivals();
    List<ProductResponseDTO> getPromotedProducts();

}