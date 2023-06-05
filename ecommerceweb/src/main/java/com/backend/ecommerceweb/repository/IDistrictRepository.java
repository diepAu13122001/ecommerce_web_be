package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IDistrictRepository extends JpaRepository<District, Long> {
    List<District> findByName(String districtName);
    List<District> findByNameContaining(String districtName);
    List<District> findByProvince(Long provinceId);
    List<District> findAllByOrderByNameAsc();
}
