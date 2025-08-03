package com.skydev.shopease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skydev.shopease.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

}
