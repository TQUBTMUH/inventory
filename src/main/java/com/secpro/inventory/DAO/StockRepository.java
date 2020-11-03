package com.secpro.inventory.DAO;

import com.secpro.inventory.entities.Item;
import com.secpro.inventory.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    Stock findByItem(Item item);
}
