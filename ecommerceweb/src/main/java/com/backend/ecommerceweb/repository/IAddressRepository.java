package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.Address;
import com.backend.ecommerceweb.entities.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {
   List<Address> findByWard(Ward ward);
   List<Address> findByAddress(String address);
}
