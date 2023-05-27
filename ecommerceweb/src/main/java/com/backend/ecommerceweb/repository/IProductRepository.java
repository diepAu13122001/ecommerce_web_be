package com.backend.ecommerceweb.repository;

import com.backend.ecommerceweb.entities.Product;
import com.backend.ecommerceweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategory(Long categoryId);
    List<Product> findAllByPriceBetween(Double minPrice, Double maxPrice);
    List<Product> findByPriceLessThan(Double minPrice);
    List<Product> findByPriceGreaterThan(Double maxPrice);
    List<Product> findByPrice(Double price);
    List<Product> findBySupplier(Long supplierId);
    List<Product> findByCost(Double cost);
    List<Product> findByCostBetween(Double minCost, Double maxCost);
    List<Product> findByCostLessThan(Double cost);
    List<Product> findByCostGreaterThan(Double cost);    
}
