package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.District;
import com.backend.ecommerceweb.entities.UserLogin;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IDistrictService;
import com.backend.ecommerceweb.services.IUserLoginService;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class DistrictService extends ABaseService implements IDistrictService {

    @Override
    public List<District> findByName(String districtName) {
        return districtRepository.findByName(districtName);
    }

    @Override
    public District findById(Long id) {
        Optional<District> d = districtRepository.findById(id);
        return d.isPresent() == false ? null : d.get();
    }

    @Override
    public List<District> findByNameContaining(String districtName) {
        return districtRepository.findByNameContaining(districtName);
    }

    @Override
    public List<District> findByProvince(Long provinceId) {
        return districtRepository.findByProvince(provinceId);
    }

    @Override
    public List<District> findAll() {
        return districtRepository.findAll();
    }

    @Override
    public List<District> findAllByOrderByNameAsc() {
        return districtRepository.findAllByOrderByNameAsc();
    }

    @Override
    public District createDistrict(District district) {
        return districtRepository.save(district);
    }

    @Override
    public void deleteById(Long id) {
        districtRepository.deleteById(id);
    }
}
