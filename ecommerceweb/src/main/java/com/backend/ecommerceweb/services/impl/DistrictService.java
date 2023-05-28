package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.District;
import com.backend.ecommerceweb.entities.UserLogin;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IUserLoginService;

import java.util.List;

@org.springframework.stereotype.Service
public class DistrictService extends ABaseService {
    List<District> findByName(String districtName) {
        return districtRepository.findByName(districtName);
    }

    List<District> findByNameContaining(String districtName) {
        return districtRepository.findByNameContaining(districtName);
    }

    List<District> findByProvince(Long provinceId) {
        return districtRepository.findByProvince(provinceId);
    }
}
