package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.Product;
import com.backend.ecommerceweb.entities.ProductDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductDescriptionRepository extends JpaRepository<ProductDescription, Long> {

}
