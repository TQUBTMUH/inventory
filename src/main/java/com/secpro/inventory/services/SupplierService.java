package com.secpro.inventory.services;

import com.secpro.inventory.entities.Supplier;

import java.util.List;

public interface SupplierService {
    public List<Supplier> findAll();

    public void save(Supplier newSupplier);

    public Supplier findById(int theId);
}
