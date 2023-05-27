package com.backend.ecommerceweb.entities;

import javax.persistence.*;

import lombok.*;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product_description")
public class ProductDescription extends BaseEntity {

    private String productStorageTemp;
    private Date expiryDate;
    private Date manufacturingDate;
    private Double productWeigh;
    private String productDes;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

}
