package com.skydev.shopease.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skydev.shopease.dto.request.CategoryRequestDTO;
import com.skydev.shopease.dto.response.CategoryResponseDTO;
import com.skydev.shopease.enums.CategoryStatus;
import com.skydev.shopease.service.CategoryService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("admin/categories")
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping()
    public List<CategoryResponseDTO> index(){
        return this.categoryService.index();
    }

    @GetMapping("{id}")
    public CategoryResponseDTO show(@RequestParam Long id) {
        return this.categoryService.show(id);
    }

    @GetMapping("/status")
    public List<CategoryResponseDTO> getCategoryByStatus(@RequestParam CategoryStatus status) {
        return categoryService.findByStatus(status);
    }
    

    @DeleteMapping
    public void delete(Long id){
        this.categoryService.delete(id);
    }
    
    @PostMapping
    public CategoryResponseDTO store(@RequestBody CategoryRequestDTO dto) {
        System.out.println("Lancement");
        return this.categoryService.store(dto);
    }

    @PutMapping("/{id}")
    public CategoryResponseDTO update(@PathVariable Long id, @RequestBody CategoryRequestDTO dto) {
        return this.categoryService.update(id, dto);
    }


    
}
