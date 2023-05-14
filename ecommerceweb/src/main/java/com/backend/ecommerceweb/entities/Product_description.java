package com.backend.ecommerceweb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "product_description")
public class Product_description extends BaseEntity{

    private String product_storageTemp;
    private int product_expiry;
    private Double product_weigh;
    private String product_des;

}
