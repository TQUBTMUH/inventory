package com.secpro.inventory.entities;

import javax.persistence.*;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Item item;

    private int quantity;

    public Stock() {
    }

    public Stock(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
