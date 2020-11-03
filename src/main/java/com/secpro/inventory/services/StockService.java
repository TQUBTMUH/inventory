package com.secpro.inventory.services;

import com.secpro.inventory.entities.Item;
import com.secpro.inventory.entities.Stock;

import java.util.List;

public interface StockService {
    public List<Stock> findAll();

    // auto increment item quantity with value from received PO items
    public void customeStockUpdate(int theId);

    public void deleteById(int theId);

    public void save(Stock stock);
}
