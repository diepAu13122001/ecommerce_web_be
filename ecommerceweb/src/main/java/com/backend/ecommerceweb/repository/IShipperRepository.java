package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.Shipper;
import com.backend.ecommerceweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IShipperRepository extends JpaRepository<Shipper, Long> {
    List<Shipper> findByName(String name);
    List<Shipper> findByNameContaining(String name);
    Shipper findByPhone(Long phone);
    Shipper findByPhoneContaining(Long phone);
    Shipper findByAddress(Long addressId);
    List<Shipper> findByEmail(String email);
    List<Shipper> findByEmailContaining(String email);
    List<Shipper> findByGender(String gender);
    List<Shipper> findByOrderNumber(String orderNum);
    List<Shipper> findByOrderNumberContaining(String orderNum);
}
