package com.secpro.inventory.services;

import com.secpro.inventory.DAO.SuppliersRepository;
import com.secpro.inventory.entities.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImp implements SupplierService {

    // injecting suppliers repository
    @Autowired
    SuppliersRepository suppliersRepository;

    @Override
    public List<Supplier> findAll() {
        return suppliersRepository.findAll();
    }

    @Override
    public void save(Supplier newSupplier) {
        Supplier supplier = suppliersRepository.findByName(newSupplier.getName());

        if (supplier == null) {
            suppliersRepository.save(newSupplier);
        } else {
            throw new RuntimeException("Supplier " + newSupplier.getName() + " already exists");
        }
    }

    @Override
    public Supplier findById(int theId) {
        Optional<Supplier> result = suppliersRepository.findById(theId);

        Supplier theSupplier;
        if (result.isPresent()) {
            theSupplier = result.get();
        } else {
            throw new RuntimeException("Supplier with id of " + theId + " doesn't exist");
        }

        return theSupplier;
    }
}
