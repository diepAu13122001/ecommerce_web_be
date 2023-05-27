package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.ProductCancel;
import com.backend.ecommerceweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IProductCancelRepository extends JpaRepository<ProductCancel, Long> {
    List<ProductCancel> findByQuantity(int quantity);

    List<ProductCancel> findByQuantityLessThanEqual(int quantity);

    List<ProductCancel> findByQuantityGreaterThanEqual(int quantity);

    List<ProductCancel> findByUnitPrice(Double unitPrice);

    List<ProductCancel> findByUnitPriceBetween(Double minUnitPrice, Double maxUnitPrice);

    List<ProductCancel> findByUnitPriceLessThanEqual(Double unitPrice);

    List<ProductCancel> findByUnitPriceGreaterThanEqual(Double unitPrice);
    List<ProductCancel> findByCreatedAt(Date createdDate);
    List<ProductCancel> findByCreatedAtBetween(Date started, Date ended);
    List<ProductCancel> findByProduct(Long productId);

}
