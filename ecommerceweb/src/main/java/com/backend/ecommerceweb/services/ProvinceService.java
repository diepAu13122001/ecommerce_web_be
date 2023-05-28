package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.Province;

import java.util.List;

public class ProvinceService extends ABaseService {
    List<Province> findByName(String name){
        return provinceRepository.findByName(name);
    }
    List<Province> findByNameContaining(String name){
        return provinceRepository.findByNameContaining(name);
    }

}
