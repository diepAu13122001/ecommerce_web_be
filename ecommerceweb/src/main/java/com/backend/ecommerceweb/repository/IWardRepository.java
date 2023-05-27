package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.District;
import com.backend.ecommerceweb.entities.Ward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IWardRepository extends JpaRepository<Ward, Long> {
    List<Ward> findByName(String wardName);
    List<Ward> findByNameContaining(String wardName);
    List<District> findByDistrict(Long id);
}
