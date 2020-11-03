package com.secpro.inventory.services;

import com.secpro.inventory.entities.PurchaseOrder;

import java.util.List;

public interface PurchaseOrderServices {
    public List<PurchaseOrder> findAll();

    public void deleteById(int theId);

    public void save(PurchaseOrder purchaseOrder);

    public PurchaseOrder findById(int theId);
}
