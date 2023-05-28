package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.Shipper;

import java.util.List;

public interface IShipperService{
    List<Shipper> findByName(String name);
    List<Shipper> findByNameContaining(String name);
    Shipper findByPhone(String phone);
    Shipper findByPhoneContaining(String phone);
    Shipper findByAddress(Long addressId);
    List<Shipper> findByEmail(String email);
    List<Shipper> findByEmailContaining(String email);
    List<Shipper> findByGender(String gender);
    List<Shipper> findByOrderNumber(String orderNum);
    List<Shipper> findByOrderNumberContaining(String orderNum);
    Shipper createShipper (Shipper shipper);
    List<Shipper> findAll();
    Shipper findById(Long shipperId);
}
