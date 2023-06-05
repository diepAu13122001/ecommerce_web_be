package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.District;
import com.backend.ecommerceweb.entities.Ward;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IWardService{
    public List<Ward> findByName(String wardName);
    List<Ward> findByNameContaining(String wardName);
    List<District> findByDistrict(Long id);
}
