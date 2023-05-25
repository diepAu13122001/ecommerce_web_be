package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.ProductCancel;
import com.backend.ecommerceweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface IProductCancelRepository extends JpaRepository<ProductCancel, Long> {

}
