package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.District;
import com.backend.ecommerceweb.entities.UserLogin;
import com.backend.ecommerceweb.entities.Ward;
import com.backend.ecommerceweb.repository.IWardRepository;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IUserLoginService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
