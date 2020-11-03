package com.secpro.inventory.services;

import com.secpro.inventory.entities.Item;

import java.util.List;

public interface ItemService {

    List<Item> findAll();

    public void save(Item newItem);

    public Item findById(Long theId);
}
