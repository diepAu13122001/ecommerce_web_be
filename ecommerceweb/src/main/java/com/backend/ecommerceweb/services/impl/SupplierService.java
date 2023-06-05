package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.Supplier;
import com.backend.ecommerceweb.entities.UserLogin;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IUserLoginService;

import java.util.List;

@org.springframework.stereotype.Service
public class SupplierService extends ABaseService{
    List<Supplier> findByName(String name){
        return supplierRepository.findByName(name);
    }
    List<Supplier> findByNameContaining(String name){
        return supplierRepository.findByNameContaining(name);
    }
    List<Supplier> findByTotalOrder(int totalOrder){
        return supplierRepository.findByTotalOrder(totalOrder);
    } 
    Supplier findByPhone(String phone){
        return supplierRepository.findByPhone(phone);
    }
    Supplier findByPhoneContaining(String phone){
        return supplierRepository.findByPhoneContaining(phone);
    }
    Supplier findByAddress(Long addressId) {
        return supplierRepository.findByAddress(addressId);
    }
    List<Supplier> findByEmail(String email){
        return supplierRepository.findByEmail(email);
    }
    List<Supplier> findByEmailContaining(String email){
        return supplierRepository.findByEmailContaining(email);
    }
    List<Supplier> findByDescriptionContaining(String description){
        return supplierRepository.findByDescriptionContaining(description);
    }
}
