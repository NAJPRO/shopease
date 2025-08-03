package com.skydev.shopease.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skydev.shopease.dto.request.StockRequestDTO;
import com.skydev.shopease.dto.response.StockResponseDTO;
import com.skydev.shopease.entity.Stock;
import com.skydev.shopease.mapper.StockMapper;
import com.skydev.shopease.repository.StockRepository;
import com.skydev.shopease.service.StockService;

@Service
public class StockServiceImpl implements StockService {
    private StockRepository stockRepository;
    private StockMapper stockMapper;
    @Override
    public void delete(Long id) {
        this.stockRepository.deleteById(id);
    }

    @Override
    public List<StockResponseDTO> findAll() {
        return this.stockMapper.tDto(this.stockRepository.findAll());
    }

    @Override
    public StockResponseDTO findById(Long id) {
        return this.stockMapper.tDto(this.stockRepository.findById(id).get());
    }

    @Override
    public StockResponseDTO store(StockRequestDTO dto) {
        return stockMapper.tDto(this.stockRepository.save(this.stockMapper.toEntity(dto)));
    }

    @Override
    public StockResponseDTO update(Long id, StockRequestDTO dto) {
        Stock lastStock = this.stockRepository.findById(id).get();
        Stock newStock = this.stockMapper.toEntity(dto);
        lastStock.setQuantity(newStock.getQuantity());
        lastStock.setStatus(newStock.getStatus());
        lastStock.setThreshold(newStock.getThreshold());
        return this.stockMapper.tDto(lastStock);
    }

    
}
