package com.backend.ecommerceweb.entities;

import javax.persistence.*;

import lombok.*;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Table(name = "product_cancel")
public class ProductCancel extends BaseEntity{

    private int quantity;
    private Double unitPrice;
    private Date createdAt;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;



}
