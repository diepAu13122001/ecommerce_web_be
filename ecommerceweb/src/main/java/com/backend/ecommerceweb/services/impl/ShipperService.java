package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.Shipper;
import com.backend.ecommerceweb.entities.UserLogin;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IShipperService;
import com.backend.ecommerceweb.services.IUserLoginService;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ShipperService extends ABaseService implements IShipperService {
    @Override
    public List<Shipper> findByName(String name){
        return shipperRepository.findByName(name);
    }
    @Override
    public List<Shipper> findByNameContaining(String name){
        return shipperRepository.findByNameContaining(name);
    }
    @Override
    public Shipper findByPhone(String phone){
        return shipperRepository.findByPhone(phone);
    }
    @Override
    public Shipper findByPhoneContaining(String phone){
        return shipperRepository.findByPhoneContaining(phone);
    }
    @Override
    public Shipper findByAddress(Long addressId){
        return shipperRepository.findByAddress(addressId);
    }
    @Override
    public List<Shipper> findByEmail(String email){
        return shipperRepository.findByEmail(email);
    }
    @Override
    public  List<Shipper> findByEmailContaining(String email){
        return shipperRepository.findByEmailContaining(email);
    }
    @Override
    public List<Shipper> findByGender(String gender){
        return shipperRepository.findByGender(gender);
    }
    @Override
    public List<Shipper> findByOrderNumber(String orderNum){
        return shipperRepository.findByOrderNumber(orderNum);
    }
    @Override
    public List<Shipper> findByOrderNumberContaining(String orderNum){
        return shipperRepository.findByOrderNumberContaining(orderNum);
    }
    @Override
    public Shipper createShipper (Shipper shipper) {
        return shipperRepository.save(shipper);
    }

    @Override
    public List<Shipper> findAll() {
        return shipperRepository.findAll();
    }

    @Override
    public Shipper findById(Long shipperId) {
        Optional<Shipper> s = shipperRepository.findById(shipperId);
        return s.isPresent() == false ? null : s.get();
    }
}
