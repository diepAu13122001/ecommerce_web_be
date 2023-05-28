package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.Product;
import com.backend.ecommerceweb.entities.UserLogin;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IUserLoginService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends ABaseService{

   List<Product> findAllByCategory(Long categoryId) {
      return productRepository.findAllByCategory(categoryId);
   }
   List<Product> findAllByPriceBetween(Double minPrice, Double maxPrice){
      return productRepository.findAllByPriceBetween(minPrice, maxPrice);
   }
   List<Product> findByPriceLessThan(Double minPrice){
      return productRepository.findByPriceLessThan(minPrice);
   }
   List<Product> findByPriceGreaterThan(Double maxPrice){
      return productRepository.findByPriceGreaterThan(maxPrice);
   }
   List<Product> findByPrice(Double price){
      return productRepository.findByPrice(price);

   }
   List<Product> findBySupplier(Long supplierId){
      return productRepository.findBySupplier(supplierId);
   }
   List<Product> findByCost(Double cost){
      return productRepository.findByCost(cost);
   }
   List<Product> findByCostBetween(Double minCost, Double maxCost){
      return productRepository.findByCostBetween(minCost, maxCost);
   }
   List<Product> findByCostLessThan(Double cost){
      return productRepository.findByCostLessThan(cost);
   }
   List<Product> findByCostGreaterThan(Double cost){
      return productRepository.findByCostGreaterThan(cost);
   }
}
