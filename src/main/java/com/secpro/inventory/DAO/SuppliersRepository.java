package com.secpro.inventory.DAO;

import com.secpro.inventory.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliersRepository extends JpaRepository<Supplier, Integer> {
    public Supplier findByName(String name);
}
