package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.ProductImage;

import java.util.List;

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
