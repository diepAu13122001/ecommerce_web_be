package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.Supplier;
import com.backend.ecommerceweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ISupplierRepository extends JpaRepository<Supplier, Long> {
    List<Supplier> findByName(String name);
    List<Supplier> findByNameContaining(String name);
    List<Supplier> findByTotalOrder(int totalOrder);
    Supplier findByPhone(String phone);
    Supplier findByPhoneContaining(String phone);
    Supplier findByAddress(Long addressId);
    List<Supplier> findByEmail(String email);
    List<Supplier> findByEmailContaining(String email);
    List<Supplier> findByDescriptionContaining(String description);

}
