package com.backend.ecommerceweb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product_description {

    @Id
    @GeneratedValue
    private Long id;
    private String product_storageTemp;
    private String product_expiry;
    private int product_weigh;
    private String product_des;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_storageTemp() {
        return product_storageTemp;
    }

    public void setProduct_storageTemp(String product_storageTemp) {
        this.product_storageTemp = product_storageTemp;
    }

    public String getProduct_expiry() {
        return product_expiry;
    }

    public void setProduct_expiry(String product_expiry) {
        this.product_expiry = product_expiry;
    }

    public int getProduct_weigh() {
        return product_weigh;
    }

    public void setProduct_weigh(int product_weigh) {
        this.product_weigh = product_weigh;
    }

    public String getProduct_des() {
        return product_des;
    }

    public void setProduct_des(String product_des) {
        this.product_des = product_des;
    }
}
