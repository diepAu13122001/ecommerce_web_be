package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.Province;
import com.backend.ecommerceweb.entities.UserLogin;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IUserLoginService;

import java.util.List;

@org.springframework.stereotype.Service
public class ProvinceService extends ABaseService {
    List<Province> findByName(String name){
        return provinceRepository.findByName(name);
    }
    List<Province> findByNameContaining(String name){
        return provinceRepository.findByNameContaining(name);
    }

}
