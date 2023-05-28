package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.District;
import com.backend.ecommerceweb.entities.Ward;
import org.springframework.stereotype.Service;

import java.util.List;

public class WardService extends ABaseService {
    public List<Ward> findByName(String wardName) {
        return wardRepository.findByName(wardName);
    }
    List<Ward> findByNameContaining(String wardName) {
        return wardRepository.findByNameContaining(wardName);
    }
    List<District> findByDistrict(Long id){
        return wardRepository.findByDistrict(id);
    }
}
