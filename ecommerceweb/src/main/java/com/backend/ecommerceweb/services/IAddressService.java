package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.Address;
import com.backend.ecommerceweb.model.dtos.address.AddressDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAddressService {
    List<Address> findByWard(Long wardId);
    List<Address> findByAddressContaining(String address);
    Address createAddress(Address address);
    Address findById(Long addressId);
    List<Address> findAll();

}
