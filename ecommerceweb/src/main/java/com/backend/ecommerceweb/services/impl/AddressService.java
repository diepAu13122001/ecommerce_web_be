package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.Address;
import com.backend.ecommerceweb.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService{
    @Autowired
    private IAddressRepository addressRepository;

    public void save(Address address) {
        addressRepository.saveAndFlush(address);
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public void delete(Long id) {
        addressRepository.deleteById(id);
    }

    public List<Address> findByWardId(Long wardId){
        List<Address> list = new ArrayList<>();
        for (Address address: findAll()) {

        }
        return null;
    }

    public List<Address> findByDistrictId(Long districtId) {
        return null;
    }

    public List<Address> findByProvinceId(Long provinceId) {
        return null;
    }

    public List<Address> findByWardName(String wardName) {
        return null;
    }

    public List<Address> findByDistrictName(String districtName) {
        return null;
    }

    public List<Address> findByProvinceName(String provinceName) {
        return null;
    }

    public List<Address> findByAddress(String address) {
        return null;
    }


}
