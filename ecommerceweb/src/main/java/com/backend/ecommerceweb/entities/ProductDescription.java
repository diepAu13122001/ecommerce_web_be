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

    private String productStorageTemp; //nhiet do bao quan ???
    private Date expiryDate; // ngay san xuat
    private Date manufacturingDate; // ngay het han
    private Double productWeigh;
    private String productDes;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

}
