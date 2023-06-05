package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.Product;
import com.backend.ecommerceweb.entities.ProductCancel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {

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

    List<Product> findAll();

    Product findById(Long id);

    Product createProduct(Product product);

    void delete(Long id);
}
