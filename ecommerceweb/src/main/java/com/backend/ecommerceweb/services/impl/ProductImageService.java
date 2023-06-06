package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.ProductImage;
import com.backend.ecommerceweb.entities.UserLogin;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IProductImageService;
import com.backend.ecommerceweb.services.IUserLoginService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImageService extends ABaseService implements IProductImageService {

    @Override
    public List<ProductImage> findByImgUrlContaining(String url) {
        return null;
    }

    @Override
    public List<ProductImage> findByImgAltContaining(String alt) {
        return null;
    }

    @Override
    public List<ProductImage> findByProduct(Long productId) {
        return null;
    }

    @Override
    public List<ProductImage> findAll() {
        return productImageRepository.findAll();
    }

    @Override
    public ProductImage findById(Long id) {
        Optional<ProductImage> p = productImageRepository.findById(id);
        return p.isPresent() == false ? null : p.get();
    }

    @Override
    public ProductImage createProductImage(ProductImage productImage) {
        return productImageRepository.save(productImage);
    }

    @Override
    public void delete(Long id) {
        productImageRepository.deleteById(id);
    }
}
