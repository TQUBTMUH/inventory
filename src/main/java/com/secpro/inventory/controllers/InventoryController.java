package com.secpro.inventory.controllers;

import com.secpro.inventory.entities.Item;
import com.secpro.inventory.entities.PurchaseOrder;
import com.secpro.inventory.entities.Stock;
import com.secpro.inventory.entities.Supplier;
import com.secpro.inventory.services.ItemService;
import com.secpro.inventory.services.PurchaseOrderServices;
import com.secpro.inventory.services.StockService;
import com.secpro.inventory.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private StockService stockService;
    @Autowired
    private ItemService itemService;

    @Autowired
    SupplierService supplierService;

    @Autowired
    PurchaseOrderServices purchaseOrderServices;

    // view all stock in inventory
    @GetMapping("/stock")
    public String findAll(Model theModel) {
        // List of Stock
        List<Stock> stockList = stockService.findAll();

        // Add List to the model
        theModel.addAttribute("stocks", stockList);

        return "inventory/stock_list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("stockId") int theId) {
        // delete stock item
        stockService.deleteById(theId);

        return "redirect:/inventory/stock";
    }

    //show order items
    @GetMapping("/purchaseOrderList")
    public String purchaseOrderList(Model theModel) {
        // create list of purchase order object
        List<PurchaseOrder> purchaseOrderList = purchaseOrderServices.findAll();

        // add list of PO in model
        theModel.addAttribute("purchaseOrderList", purchaseOrderList);

        return "inventory/purchase_order_list";
    }

    // order form for receiving
    @GetMapping("/showOrderForm")
    public String showOrderForm(@RequestParam("purchaseOrderId") int theId,
                                Model theModel) {

        // show form for update and receiving purchase order
        PurchaseOrder thePurchaseOrder = purchaseOrderServices.findById(theId);
        theModel.addAttribute("purchaseOrder", thePurchaseOrder);

        return "inventory/order_form";
    }


    // new ordering form
    @GetMapping("/newOrderForm")
    public String createOrderForm(Model theModel) {

        // show form for update and adding purchase order
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        theModel.addAttribute("purchaseOrder", purchaseOrder);
        theModel.addAttribute("suppliers",supplierService.findAll());
        theModel.addAttribute("items",itemService.findAll());

        return "inventory/order_form";
    }

    // save order and receive order
    @PostMapping("/save")
    public String saveOrder(@Valid @ModelAttribute("purchaseOrder") PurchaseOrder purchaseOrder,
                            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "redirect:/inventory/newOrderForm";
        } else {
            // update or save purchase order
            if (purchaseOrder.getId() > 0) {
                // updates stock items
                stockService.customeStockUpdate(purchaseOrder.getId());
                deletePurchaseOrder(purchaseOrder.getId());
            } else {
                purchaseOrderServices.save(purchaseOrder);
            }
            return "redirect:/inventory/purchaseOrderList";
        }
    }

    @GetMapping("/deleteOrder")
    public String deletePurchaseOrder(@RequestParam("purchaseOrderId") int theId) {
        // delete stock item
        purchaseOrderServices.deleteById(theId);

        return "redirect:/inventory/purchaseOrderList";
    }

    @GetMapping("/newItemForm")
    public String newItemForm(Model theModel) {
        Item item = new Item();

        theModel.addAttribute("item", item);

        return "inventory/item_new_form";
    }

    @GetMapping("/newSupplierForm")
    public String newSupplierForm(Model theModel) {
        Supplier supplier = new Supplier();

        theModel.addAttribute("supplier", supplier);

        return "inventory/supplier_new_form";
    }

    @PostMapping("/saveSupplier")
    public String saveSupplier(@Valid @ModelAttribute("supplier") Supplier newSupplier,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "inventory/supplier_new_form";
        } else {
            supplierService.save(newSupplier);
            return "redirect:/inventory/newOrderForm";
        }
    }

    // save new Item in Item and Stock databases
    @PostMapping("/saveItem")
    public String saveNewItem(@Valid @ModelAttribute("item") Item newItem,
                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "inventory/item_new_form";
        } else {
            // save the item
            itemService.save(newItem);
            Item savedItem = itemService.findById(newItem.getId());

            // update stock Item
            Stock newStock = new Stock(savedItem, 0);
            stockService.save(newStock);

            return "redirect:/inventory/stock";
        }
    }
}
