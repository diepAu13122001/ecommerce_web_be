package com.backend.ecommerceweb.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product")
public class Product  extends  BaseEntity{

    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "category_id", referencedColumnName = "id")
    private Category category;

    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "supplier_id", referencedColumnName = "id")
    private Supplier supplier;

    private Double cost;

    @OneToMany
    @JoinColumn(name = "product_image", referencedColumnName = "id")
    @JsonIgnoreProperties("product_id")
    private List<ProductImage> productImages;


}
