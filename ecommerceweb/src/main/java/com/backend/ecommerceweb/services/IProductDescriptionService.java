package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.ProductDescription;
import com.backend.ecommerceweb.entities.ProductImage;

import java.util.Date;
import java.util.List;

public interface IProductDescriptionService {
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

    ProductDescription findByProduct(Long productId);

    List<ProductDescription> findAll();

    ProductDescription findById(Long id);

    ProductDescription createProductImage(ProductDescription productDescription);

    void delete(Long id);
}
