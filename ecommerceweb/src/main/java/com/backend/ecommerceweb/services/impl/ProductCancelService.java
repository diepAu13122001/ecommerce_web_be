package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.ProductCancel;
import com.backend.ecommerceweb.entities.UserLogin;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IProductCancelService;
import com.backend.ecommerceweb.services.IUserLoginService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductCancelService extends ABaseService implements IProductCancelService {
    public List<ProductCancel> findByQuantity(Integer quantity) {
        return productCancelRepository.findByQuantity(quantity);
    }

    public List<ProductCancel> findByQuantityLessThanEqual(Integer quantity) {
        return productCancelRepository.findByQuantityLessThanEqual(quantity);
    }

    public List<ProductCancel> findByQuantityGreaterThanEqual(Integer quantity) {
        return productCancelRepository.findByQuantityGreaterThanEqual(quantity);
    }

    public List<ProductCancel> findByUnitPrice(Double unitPrice) {
        return productCancelRepository.findByUnitPrice(unitPrice);
    }

    public List<ProductCancel> findByUnitPriceBetween(Double minUnitPrice, Double maxUnitPrice) {
        return productCancelRepository.findByUnitPriceBetween(minUnitPrice, maxUnitPrice);
    }

    public List<ProductCancel> findByUnitPriceLessThanEqual(Double unitPrice) {
        return productCancelRepository.findByUnitPriceLessThanEqual(unitPrice);
    }

    public List<ProductCancel> findByUnitPriceGreaterThanEqual(Double unitPrice) {
        return productCancelRepository.findByUnitPriceGreaterThanEqual(unitPrice);
    }

    public List<ProductCancel> findByCreatedAt(Date createdDate) {
        return productCancelRepository.findByCreatedAt(createdDate);
    }

    public List<ProductCancel> findByCreatedAtBetween(Date started, Date ended) {
        return productCancelRepository.findByCreatedAtBetween(started, ended);
    }

    public List<ProductCancel> findByProduct(Long productId) {
        return productCancelRepository.findByProduct(productId);
    }

    @Override
    public List<ProductCancel> findAll() {
        return productCancelRepository.findAll();
    }

    @Override
    public ProductCancel findById(Long id) {
        Optional<ProductCancel> p = productCancelRepository.findById(id);
        return p.isPresent() == false ? null : p.get();
    }

    @Override
    public List<ProductCancel> findAllByOrderByUnitPriceAsc() {
        return productCancelRepository.findAllByOrderByUnitPriceAsc();
    }

    @Override
    public List<ProductCancel> findAllByOrderByUnitPriceDesc() {
        return productCancelRepository.findAllByOrderByUnitPriceDesc();
    }

    @Override
    public List<ProductCancel> findAllByOrderByCreatedAtDesc() {
        return productCancelRepository.findAllByOrderByCreatedAtDesc();

    }

    @Override
    public List<ProductCancel> findAllByOrderByQuantityAsc() {
        return productCancelRepository.findAllByOrderByQuantityAsc();
    }

    @Override
    public List<ProductCancel> findAllByOrderByQuantityDesc() {
        return productCancelRepository.findAllByOrderByQuantityDesc();

    }

    @Override
    public ProductCancel createProductCancel(ProductCancel productCancel) {
        return productCancelRepository.save(productCancel);
    }

    @Override
    public void delete(Long id) {
        productCancelRepository.deleteById(id);
    }
}
