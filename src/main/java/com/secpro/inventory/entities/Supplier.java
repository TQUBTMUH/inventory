package com.secpro.inventory.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "*required")
    private String name;

    public Supplier() {
    }

    public Supplier(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String supplierName) {
        this.name = supplierName;
    }

    // to string
    @Override
    public String toString() {
        return "Suppliers{" +
                "id=" + id +
                ", supplierName='" + name + '\'' +
                '}';
    }
}
