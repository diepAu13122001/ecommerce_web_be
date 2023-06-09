package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.Category;
import com.backend.ecommerceweb.entities.District;

import java.util.List;

public interface IDistrictService {
    List<District> findByName(String districtName);
    District findById(Long id);

    List<District> findByNameContaining(String districtName);

    List<District> findByProvince(Long provinceId);

    List<District> findAll();

    List<District> findAllByOrderByNameAsc();

    District createDistrict(District district);

    void deleteById(Long id);
}
