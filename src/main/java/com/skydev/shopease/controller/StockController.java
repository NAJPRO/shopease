package com.skydev.shopease.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skydev.shopease.dto.request.StockRequestDTO;
import com.skydev.shopease.dto.response.StockResponseDTO;
import com.skydev.shopease.service.StockService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("stock")
public class StockController {
    private StockService stockService;

    @GetMapping
    public List<StockResponseDTO>  findAll() {
        return this.stockService.findAll();
    }
    
    @GetMapping("/{id}")
    public StockResponseDTO findById(@RequestParam Long id) {
        return this.stockService.findById(id);
    }

    @PostMapping
    public StockResponseDTO store(@RequestBody StockRequestDTO dto) {
        return this.stockService.store(dto);
    }
    
    @PutMapping("/{id}")
    public StockResponseDTO update(@PathVariable Long id, @RequestBody StockRequestDTO dto) {
        return this.stockService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.stockService.delete(id);
    }
    
}
