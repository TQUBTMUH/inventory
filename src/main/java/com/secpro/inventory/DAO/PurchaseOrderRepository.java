package com.secpro.inventory.DAO;

import com.secpro.inventory.entities.PurchaseOrder;
import com.secpro.inventory.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Integer> {
    PurchaseOrder findById(int theId);

    // will work with stock item in updating new item
    // if it's not on stock item
    Stock findByItem_Id(Long theId);
}
