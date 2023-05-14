package com.backend.ecommerceweb.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@Table(name = "user_cart")
public class UserCart extends BaseEntity {

    @OneToMany
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private List<Product> products;

    private int product_amount;
    private Long gift_id;


}
