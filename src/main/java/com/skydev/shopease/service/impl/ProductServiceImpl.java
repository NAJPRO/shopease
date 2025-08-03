package com.skydev.shopease.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.skydev.shopease.dto.request.ProductRequestDTO;
import com.skydev.shopease.dto.response.ProductResponseDTO;
import com.skydev.shopease.entity.Product;
import com.skydev.shopease.mapper.ProductMapper;
import com.skydev.shopease.repository.ProductRepository;
import com.skydev.shopease.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
@AllArgsConstructor
@Getter
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponseDTO create(ProductRequestDTO dto) {
        Product product = this.productRepository.save(this.productMapper.toEntity(dto));

        return this.productMapper.toDto(product);
    }

    @Override
    public void delete(Long id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public List<ProductResponseDTO> filterByStockAvailability(boolean inStock) {
        List<Product> products = this.productRepository.findByStock_QuantityGreaterThan(0);
        return this.productMapper.toDto(products);
    }

    @Override
    public List<ProductResponseDTO> filterProductByCategory(Long categoryId) {
        List<Product> products = this.productRepository.findByCategory_Id(categoryId);
        return this.productMapper.toDto(products);
    }

    @Override
    public List<ProductResponseDTO> filterProductsByPriceRange(BigDecimal min, BigDecimal max) {
        List<Product> products = this.productRepository.findByPriceBetween(min, max);
        return this.productMapper.toDto(products);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = this.productRepository.findAll();
        // Utilisation des Streams pour mapper chaque Product en ProductRequestDTO
        List<ProductResponseDTO> pResponseDTOs = products.stream()
                .map(this.productMapper::toDto) // Applique la méthode toDto à chaque Product
                .collect(Collectors.toList()); // Collecte les résultats dans une nouvelle liste

        return pResponseDTOs;
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        Product product = this.productRepository.findById(id);
        return this.productMapper.toDto(product);
    }

    @Override
    public List<ProductResponseDTO> getPromotedProducts() {
        List<Product> products = this.productRepository.findByFeatured(true);
        return this.productMapper.toDto(products);
    }

    @Override
    public List<ProductResponseDTO> sarchProducts(String keyString) {
        List<Product> products = this.productRepository.searchByKeyword(keyString);
        return this.productMapper.toDto(products);
    }

    @Override
    public ProductResponseDTO update(Long id, ProductRequestDTO dto) {
        Product lastProduct = this.productRepository.findById(id);
        Product newProduct = this.productMapper.toEntity(dto);
        lastProduct.setPicture(newProduct.getPicture());
        lastProduct.setTitle(newProduct.getTitle());
        lastProduct.setPrice(newProduct.getPrice());
        lastProduct.setPromotionalPrice(newProduct.getPromotionalPrice());
        lastProduct.setDescription(newProduct.getDescription());
        lastProduct.setPicture(newProduct.getPicture());
        this.productRepository.save(lastProduct);
        return this.productMapper.toDto(lastProduct);
    }

}
