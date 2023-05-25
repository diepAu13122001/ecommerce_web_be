package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.Address;
import com.backend.ecommerceweb.entities.District;
import com.backend.ecommerceweb.entities.Province;
import com.backend.ecommerceweb.entities.Ward;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IAddressRepositoryTest {

    @Autowired
    private IAddressRepository addressRepository;
    @Autowired
    private IDistrictRepository districtRepository;
    @Autowired
    private IWardRepository wardRepository;


    @Test
    void save() {
       Ward ward = wardRepository.findById(1L).get();
        Address address = Address.builder().address("abc").ward(ward).build();
        addressRepository.save(address);
    }

    @Test
    void findByWardId() {
        Ward ward = wardRepository.getById(1L);
        System.out.println(ward.getName());
        //System.out.println(addressRepository.findByWard(ward).get(0).getAddress());
    }
}