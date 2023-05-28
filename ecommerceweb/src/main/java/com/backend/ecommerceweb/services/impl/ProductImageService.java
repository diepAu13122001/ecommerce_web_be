package com.backend.ecommerceweb.services.impl;

import com.backend.ecommerceweb.entities.ProductImage;
import com.backend.ecommerceweb.entities.UserLogin;
import com.backend.ecommerceweb.services.ABaseService;
import com.backend.ecommerceweb.services.IUserLoginService;

import java.util.List;

@org.springframework.stereotype.Service
public class ProductImageService extends ABaseService{
    List<ProductImage> findByImgUrlContaining(String url){
        return productImageRepository.findByImgUrlContaining(url);
    }
    List<ProductImage> findByImgAltContaining(String alt){
        return productImageRepository.findByImgAltContaining(alt);
    }
    List<ProductImage> findByProduct(Long productId){
        return productImageRepository.findByProduct(productId);
    }
}
