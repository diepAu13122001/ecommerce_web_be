package com.backend.ecommerceweb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ProductImage {

    @Id
    @GeneratedValue
    private Long id;
    private String product_img;
    private String product_img_alt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }

    public String getProduct_img_alt() {
        return product_img_alt;
    }

    public void setProduct_img_alt(String product_img_alt) {
        this.product_img_alt = product_img_alt;
    }
}
