package com.secpro.inventory.services;

import com.secpro.inventory.DAO.PurchaseOrderRepository;
import com.secpro.inventory.entities.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderServicesImp implements PurchaseOrderServices{

    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public List<PurchaseOrder> findAll() {
        return purchaseOrderRepository.findAll();
    }

    @Override
    public void deleteById(int theId) {
        purchaseOrderRepository.deleteById(theId);
    }

    @Override
    public void save(PurchaseOrder purchaseOrder) {
        purchaseOrderRepository.save(purchaseOrder);
    }

    @Override
    public PurchaseOrder findById(int theId) {
        return purchaseOrderRepository.findById(theId);
    }
}
