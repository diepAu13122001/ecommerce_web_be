package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.ProductImage;
import com.backend.ecommerceweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface IProductImageRepository extends JpaRepository<ProductImage, Long> {

}
