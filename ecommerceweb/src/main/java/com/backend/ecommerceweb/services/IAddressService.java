package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAddressService {
    List<Address> findByWard(Long wardId);
    List<Address> findByAddressContaining(String address);

}
