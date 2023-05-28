package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.ProductCancel;

import java.util.Date;
import java.util.List;

public class ProductCancelService extends ABaseService{
    List<ProductCancel> findByQuantity(int quantity){
        return productCancelRepository.findByQuantity(quantity);
    }

    List<ProductCancel> findByQuantityLessThanEqual(int quantity){
        return productCancelRepository.findByQuantityLessThanEqual(quantity);
    }

    List<ProductCancel> findByQuantityGreaterThanEqual(int quantity){
        return productCancelRepository.findByQuantityGreaterThanEqual(quantity);
    }

    List<ProductCancel> findByUnitPrice(Double unitPrice){
        return productCancelRepository.findByUnitPrice(unitPrice);
    }

    List<ProductCancel> findByUnitPriceBetween(Double minUnitPrice, Double maxUnitPrice){
        return productCancelRepository.findByUnitPriceBetween(minUnitPrice, maxUnitPrice);
    }

    List<ProductCancel> findByUnitPriceLessThanEqual(Double unitPrice){
        return productCancelRepository.findByUnitPriceLessThanEqual(unitPrice);
    }

    List<ProductCancel> findByUnitPriceGreaterThanEqual(Double unitPrice){
        return productCancelRepository.findByUnitPriceGreaterThanEqual(unitPrice);
    }

    List<ProductCancel> findByCreatedAt(Date createdDate){
        return productCancelRepository.findByCreatedAt(createdDate);
    }

    List<ProductCancel> findByCreatedAtBetween(Date started, Date ended){
        return productCancelRepository.findByCreatedAtBetween(started, ended);
    }

    List<ProductCancel> findByProduct(Long productId){
        return productCancelRepository.findByProduct(productId);
    }
}
