package com.secpro.inventory.entities;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "purchase_order")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date orderDate;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private Item item;

    @Min(value = 1, message = "required more than 1")
    private int quantity;

    public PurchaseOrder(Date orderDate, Supplier supplier, Item item, int quantity) {
        this.orderDate = orderDate;
        this.supplier = supplier;
        this.item = item;
        this.quantity = quantity;
    }

    public PurchaseOrder() {
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // to string

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", supplier='" + supplier + '\'' +
                ", item='" + item + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
