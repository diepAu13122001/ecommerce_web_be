package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.Address;
import com.backend.ecommerceweb.repository.IAddressRepository;
import com.backend.ecommerceweb.services.ABaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService extends ABaseService {
    List<Address> findByWard(Long wardId) {
        return addressRepository.findByWard(wardId);
    }
    List<Address> findByAddressContaining(String address) {
        return addressRepository.findByAddressContaining(address);
    }

}
