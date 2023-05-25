package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.Shipper;
import com.backend.ecommerceweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IShipperRepository extends JpaRepository<Shipper, Long> {
}
