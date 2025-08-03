package com.skydev.shopease.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.skydev.shopease.dto.request.ProductRequestDTO;
import com.skydev.shopease.dto.response.ProductResponseDTO;
import com.skydev.shopease.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/products") // Corrigé: ce n'est pas le `name`, mais le `value` ici
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    // GET /products
    @GetMapping
    public List<ProductResponseDTO> index() {
        return productService.getAllProducts();
    }

    // GET /products/{id}
    @GetMapping("/{id}")
    public ProductResponseDTO show(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // POST /products
    @PostMapping
    public ProductResponseDTO store(@RequestBody ProductRequestDTO dto) {
        return productService.create(dto);
    }

    // PUT /products/{id}
    @PutMapping("/{id}")
    public ProductResponseDTO update(@PathVariable Long id, @RequestBody ProductRequestDTO dto) {
        return productService.update(id, dto);
    }

    // DELETE /products/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    // GET /products/search?keyword=example
    @GetMapping("/search")
    public List<ProductResponseDTO> search(@RequestParam String keyword) {
        return productService.sarchProducts(keyword);
    }

    // GET /products/category/{categoryId}
    @GetMapping("/category/{categoryId}")
    public List<ProductResponseDTO> filterProductByCategory(@PathVariable Long categoryId) {
        return productService.filterProductByCategory(categoryId);
    }

    // GET /products/in-stock?available=true
    @GetMapping("/in-stock")
    public List<ProductResponseDTO> filterByStockAvailability(@RequestParam boolean available) {
        return productService.filterByStockAvailability(available);
    }

    // GET /products/promoted
    @GetMapping("/promoted")
    public List<ProductResponseDTO> getPromotedProducts() {
        return productService.getPromotedProducts();
    }

    // GET /products/top-selling
    // @GetMapping("/top-selling")
    // public List<ProductResponseDTO> getTopSellingProducts() {
    //     return productService.getTopSellingProducts();
    // }

    // GET /products/price-range?min=10&max=50
    @GetMapping("/price-range")
    public List<ProductResponseDTO> filterProductsByPriceRange(
            @RequestParam BigDecimal min,
            @RequestParam BigDecimal max) {
        return productService.filterProductsByPriceRange(min, max);
    }
}
