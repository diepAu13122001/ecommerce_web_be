package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.ProductCancel;

import java.util.Date;
import java.util.List;

public interface IProductCancelService {
    List<ProductCancel> findByQuantity(Integer quantity);

    List<ProductCancel> findByQuantityLessThanEqual(Integer quantity);

    List<ProductCancel> findByQuantityGreaterThanEqual(Integer quantity);

    List<ProductCancel> findByUnitPrice(Double unitPrice);

    List<ProductCancel> findByUnitPriceBetween(Double minUnitPrice, Double maxUnitPrice);

    List<ProductCancel> findByUnitPriceLessThanEqual(Double unitPrice);

    List<ProductCancel> findByUnitPriceGreaterThanEqual(Double unitPrice);

    List<ProductCancel> findByCreatedAt(Date createdDate);

    List<ProductCancel> findByCreatedAtBetween(Date started, Date ended);

    List<ProductCancel> findByProduct(Long productId);

    List<ProductCancel> findAll();

    ProductCancel findById(Long id);

    List<ProductCancel> findAllByOrderByUnitPriceAsc();

    List<ProductCancel> findAllByOrderByUnitPriceDesc();

    List<ProductCancel> findAllByOrderByCreatedAtDesc();

    List<ProductCancel> findAllByOrderByQuantityAsc();

    List<ProductCancel> findAllByOrderByQuantityDesc();

    ProductCancel createProductCancel(ProductCancel productCancel);

    void delete(Long id);

}
