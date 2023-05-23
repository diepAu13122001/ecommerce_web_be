package com.backend.ecommerceweb.entities;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "product_description")
public class ProductDescription extends BaseEntity{

    private String product_storageTemp;
    private int product_expiry;
    private Double product_weigh;
    private String product_des;

}
