package com.backend.ecommerceweb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserCart {

    @Id
    @GeneratedValue
    private Long id;
    private Long product_id;
    private int product_amount;
    private Long gift_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public int getProduct_amount() {
        return product_amount;
    }

    public void setProduct_amount(int product_amount) {
        this.product_amount = product_amount;
    }

    public Long getGift_id() {
        return gift_id;
    }

    public void setGift_id(Long gift_id) {
        this.gift_id = gift_id;
    }
}
