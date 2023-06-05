package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.Province;

import java.util.List;

public interface IProvinceService {
    List<Province> findByName(String name);

    List<Province> findByNameContaining(String name);

    Province findById(Long id);

    List<Province> findAll();

    List<Province> findAllByOrderByNameAsc();

    Province createProvince(Province province);

    void deleteById(Long id);

}
