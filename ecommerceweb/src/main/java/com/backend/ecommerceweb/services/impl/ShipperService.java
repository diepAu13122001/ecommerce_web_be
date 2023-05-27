package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.Shipper;
import com.backend.ecommerceweb.entities.UserLogin;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IUserLoginService;

import java.util.List;

@org.springframework.stereotype.Service
public class ShipperService extends ABaseService{
    List<Shipper> findByName(String name){
        return shipperRepository.findByName(name);
    }
    List<Shipper> findByNameContaining(String name){
        return shipperRepository.findByNameContaining(name);
    }
    Shipper findByPhone(Long phone){
        return shipperRepository.findByPhone(phone);
    }
    Shipper findByPhoneContaining(Long phone){
        return shipperRepository.findByPhoneContaining(phone);
    }
    Shipper findByAddress(Long addressId){
        return shipperRepository.findByAddress(addressId);
    }
    List<Shipper> findByEmail(String email){
        return shipperRepository.findByEmail(email);
    }
    List<Shipper> findByEmailContaining(String email){
        return shipperRepository.findByEmailContaining(email);
    }
    List<Shipper> findByGender(String gender){
        return shipperRepository.findByGender(gender);
    }
    List<Shipper> findByOrderNumber(String orderNum){
        return shipperRepository.findByOrderNumber(orderNum);
    }
    List<Shipper> findByOrderNumberContaining(String orderNum){
        return shipperRepository.findByOrderNumberContaining(orderNum);
    }
}
