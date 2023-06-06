package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.Product;
import com.backend.ecommerceweb.entities.ProductDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IProductDescriptionRepository extends JpaRepository<ProductDescription, Long> {
    List<ProductDescription> findByProductStorageTemp(String productStorageTemp);

    List<ProductDescription> findByProductStorageTempContaining(String productStorageTemp);

    List<ProductDescription> findByExpiryDate(Date expiryDate);

    List<ProductDescription> findByExpiryDateGreaterThanEqual(Date expiryDate);

    List<ProductDescription> findByManufacturingDate(Date manufacturingDate);

    List<ProductDescription> findByManufacturingDateLessThanEqual(Date manufacturingDate);

    List<ProductDescription> findByExpiryDateGreaterThanEqualAndManufacturingDateLessThanEqual(Date expiryDate, Date manufacturingDate);

    List<ProductDescription> findByProductWeigh(Double productWeigh);

    List<ProductDescription> findByProductWeighLessThanEqual(Double productWeigh);

    List<ProductDescription> findByProductWeighGreaterThanEqual(Double productWeigh);

    List<ProductDescription> findByProductDesContaining(String description);

    ProductDescription findByProductId(@Param("id") Long productId);

}
