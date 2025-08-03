package com.skydev.shopease.service;

import java.util.List;

import com.skydev.shopease.dto.request.StockRequestDTO;
import com.skydev.shopease.dto.response.StockResponseDTO;

public interface StockService {
    StockResponseDTO store(StockRequestDTO dto);
    StockResponseDTO update(Long id, StockRequestDTO dto);
    void delete(Long id);
    StockResponseDTO findById(Long id);
    List<StockResponseDTO> findAll();
}
