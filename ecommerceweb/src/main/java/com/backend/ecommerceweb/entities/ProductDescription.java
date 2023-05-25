package com.backend.ecommerceweb.entities;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Table(name = "product_description")
public class ProductDescription extends BaseEntity {

    private String product_storageTemp;
    private int product_expiry;
    private Double product_weigh;
    private String product_des;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

}
