package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

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

//       Ward ward = Ward.builder().name("1").district().build();
//        Address address = Address.builder().address("abc").ward(ward).build();
//        addressRepository.save(address);
    }

    @Test
    void findByWardId() {
        Optional<Ward> u = wardRepository.findById(1L);
        System.out.println(1L);
        System.out.println(u.isPresent() == false ? null : u.get().getName());
        //System.out.println(addressRepository.findByWard(ward).get(0).getAddress());
    }
}