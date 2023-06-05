package com.backend.ecommerceweb.services;

import com.backend.ecommerceweb.entities.ProductImage;

import java.util.List;

public interface IProductImageService {
    List<ProductImage> findByImgUrlContaining(String url);

    List<ProductImage> findByImgAltContaining(String alt);

    List<ProductImage> findByProduct(Long productId);

    List<ProductImage> findAll();

    ProductImage findById(Long id);

    ProductImage createProductImage(ProductImage productImage);

    void delete(Long id);
}
