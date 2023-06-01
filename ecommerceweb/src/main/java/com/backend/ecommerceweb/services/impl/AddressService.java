package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.Address;
import com.backend.ecommerceweb.entities.Shipper;
import com.backend.ecommerceweb.repository.IAddressRepository;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService extends ABaseService implements IAddressService {
    @Override
    public List<Address> findByWard(Long wardId) {
        return addressRepository.findByWard(wardId);
    }

    @Override

    public List<Address> findByAddressContaining(String address) {
        return addressRepository.findByAddressContaining(address);
    }

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address findById(Long addressId) {
        Optional<Address> a = addressRepository.findById(addressId);
        return a.isPresent() == false ? null : a.get();
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

}
