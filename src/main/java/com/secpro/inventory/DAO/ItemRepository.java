package com.secpro.inventory.DAO;

import com.secpro.inventory.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    public Item findByName(String itemName);
    public Item findByCode(String code);
}
