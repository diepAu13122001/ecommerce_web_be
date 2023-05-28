package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.District;

import java.util.List;

public interface IDistrictService{
    List<District> findByName(String districtName);
    List<District> findByNameContaining(String districtName);

    List<District> findByProvince(Long provinceId);
}
