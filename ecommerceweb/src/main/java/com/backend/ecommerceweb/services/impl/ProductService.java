package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.Product;
import com.backend.ecommerceweb.entities.UserLogin;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IProductService;
import com.backend.ecommerceweb.services.IUserLoginService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService extends ABaseService implements IProductService {

    public List<Product> findAllByCategory(Long categoryId) {
        return productRepository.findAllByCategory(categoryId);
    }

    public List<Product> findAllByPriceBetween(Double minPrice, Double maxPrice) {
        return productRepository.findAllByPriceBetween(minPrice, maxPrice);
    }

    public List<Product> findByPriceLessThan(Double minPrice) {
        return productRepository.findByPriceLessThan(minPrice);
    }

    public List<Product> findByPriceGreaterThan(Double maxPrice) {
        return productRepository.findByPriceGreaterThan(maxPrice);
    }

    public List<Product> findByPrice(Double price) {
        return productRepository.findByPrice(price);

    }

    public List<Product> findBySupplier(Long supplierId) {
        return productRepository.findBySupplier(supplierId);
    }

    public List<Product> findByCost(Double cost) {
        return productRepository.findByCost(cost);
    }

    public List<Product> findByCostBetween(Double minCost, Double maxCost) {
        return productRepository.findByCostBetween(minCost, maxCost);
    }

    public List<Product> findByCostLessThan(Double cost) {
        return productRepository.findByCostLessThan(cost);
    }

    public List<Product> findByCostGreaterThan(Double cost) {
        return productRepository.findByCostGreaterThan(cost);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> p = productRepository.findById(id);
        return p.isPresent() == false ? null : p.get();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
