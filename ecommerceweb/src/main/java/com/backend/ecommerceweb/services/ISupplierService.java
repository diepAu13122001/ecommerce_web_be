package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.Supplier;

import java.util.List;

public interface ISupplierService {
    List<Supplier> findByName(String name);

    List<Supplier> findByNameContaining(String name);

    List<Supplier> findByTotalOrder(int totalOrder);

    Supplier findByPhone(String phone);

    Supplier findByPhoneContaining(String phone);

    Supplier findByAddress(Long addressId);

    List<Supplier> findByEmail(String email);

    List<Supplier> findByEmailContaining(String email);

    List<Supplier> findByDescriptionContaining(String description);

    Supplier findById(Long id);

    List<Supplier> findAll();

    Supplier createSupplier(Supplier supplier);

    void delete(Long id);
}
