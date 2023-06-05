package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.Province;
import com.backend.ecommerceweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IProvinceRepository extends JpaRepository<Province, Long> {
    List<Province> findByName(String name);

    List<Province> findByNameContaining(String name);

    List<Province> findAllByOrderByNameAsc();
}
