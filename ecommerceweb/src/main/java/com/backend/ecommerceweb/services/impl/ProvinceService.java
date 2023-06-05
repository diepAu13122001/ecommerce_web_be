package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.Province;
import com.backend.ecommerceweb.entities.UserLogin;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IProvinceService;
import com.backend.ecommerceweb.services.IUserLoginService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinceService extends ABaseService implements IProvinceService {
    @Override
    public List<Province> findByName(String name) {
        return provinceRepository.findByName(name);
    }

    @Override
    public List<Province> findByNameContaining(String name) {
        return provinceRepository.findByNameContaining(name);
    }

    @Override
    public Province findById(Long id) {
        Optional<Province> p = provinceRepository.findById(id);
        return p.isPresent() == false ? null : p.get();
    }

    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public List<Province> findAllByOrderByNameAsc() {
        return provinceRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Province createProvince(Province province) {
        return provinceRepository.save(province);
    }

    @Override
    public void deleteById(Long id) {
        provinceRepository.deleteById(id);
    }

}
