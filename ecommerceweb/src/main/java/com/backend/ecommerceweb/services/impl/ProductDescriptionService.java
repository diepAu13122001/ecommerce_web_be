package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.ProductDescription;
import com.backend.ecommerceweb.entities.ProductImage;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IProductDescriptionService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ProductDescriptionService extends ABaseService implements IProductDescriptionService {

    @Override
    public List<ProductDescription> findByProductStorageTemp(String productStorageTemp) {
        return productDescriptionRepository.findByProductStorageTemp(productStorageTemp);
    }

    @Override
    public List<ProductDescription> findByProductStorageTempContaining(String productStorageTemp) {
        return productDescriptionRepository.findByProductStorageTempContaining(productStorageTemp);
    }

    @Override
    public List<ProductDescription> findByExpiryDate(Date expiryDate) {
        return productDescriptionRepository.findByExpiryDate(expiryDate);
    }

    @Override
    public List<ProductDescription> findByExpiryDateGreaterThanEqual(Date expiryDate) {
        return productDescriptionRepository.findByExpiryDateGreaterThanEqual(expiryDate);
    }

    @Override
    public List<ProductDescription> findByManufacturingDate(Date manufacturingDate) {
        return productDescriptionRepository.findByManufacturingDate(manufacturingDate);
    }

    @Override
    public List<ProductDescription> findByManufacturingDateLessThanEqual(Date manufacturingDate) {
        return productDescriptionRepository.findByManufacturingDateLessThanEqual(manufacturingDate);
    }

    @Override
    public List<ProductDescription> findByExpiryDateGreaterThanEqualAndManufacturingDateLessThanEqual(Date expiryDate, Date manufacturingDate) {
        return productDescriptionRepository.findByExpiryDateGreaterThanEqualAndManufacturingDateLessThanEqual(expiryDate, manufacturingDate);
    }

    @Override
    public List<ProductDescription> findByProductWeigh(Double productWeigh) {
        return productDescriptionRepository.findByProductWeigh(productWeigh);
    }

    @Override
    public List<ProductDescription> findByProductWeighLessThanEqual(Double productWeigh) {
        return productDescriptionRepository.findByProductWeighLessThanEqual(productWeigh);
    }

    @Override
    public List<ProductDescription> findByProductWeighGreaterThanEqual(Double productWeigh) {
        return productDescriptionRepository.findByProductWeighGreaterThanEqual(productWeigh);
    }

    @Override
    public List<ProductDescription> findByProductDesContaining(String description) {
        return productDescriptionRepository.findByProductDesContaining(description);
    }

    @Override
    public ProductDescription findByProduct(Long productId) {
        return productDescriptionRepository.findByProduct(productId);
    }

    @Override
    public List<ProductDescription> findAll() {
        return productDescriptionRepository.findAll();
    }

    @Override
    public ProductDescription findById(Long id) {
        Optional<ProductDescription> p = productDescriptionRepository.findById(id);
        return p.isPresent() == false ? null : p.get();
    }

    @Override
    public ProductDescription createProductImage(ProductDescription ProductDescription) {
        return productDescriptionRepository.save(ProductDescription);
    }

    @Override
    public void delete(Long id) {
            productDescriptionRepository.deleteById(id);
    }
}
