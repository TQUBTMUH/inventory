package com.secpro.inventory.services;

import com.secpro.inventory.DAO.PurchaseOrderRepository;
import com.secpro.inventory.DAO.StockRepository;
import com.secpro.inventory.entities.Item;
import com.secpro.inventory.entities.PurchaseOrder;
import com.secpro.inventory.entities.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImp implements StockService {

    // injecting stock repository
    @Autowired
    StockRepository stockRepository;

    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    @Override
    public void deleteById(int theId) {
        stockRepository.deleteById(theId);
    }

    @Override
    public void save(Stock stock) {
        stockRepository.save(stock);
    }

    @Override
    public void customeStockUpdate(int theId) {
        // get the item in PO with given Id
        PurchaseOrder myPurchaserOrder = purchaseOrderRepository.findById(theId);
        // find stock record using it's name in purchaseOrder database
        Stock myStock = stockRepository.findByItem(myPurchaserOrder.getItem());

        // get stock item's ID
        int myStockQuantity = myStock.getQuantity();

        // update stock quantity
        myStockQuantity += myPurchaserOrder.getQuantity();

        // update stock quantity of Stock Item
        myStock.setQuantity(myStockQuantity);
        stockRepository.save(myStock);
    }


}
