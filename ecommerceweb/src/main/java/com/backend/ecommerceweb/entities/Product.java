package com.backend.ecommerceweb.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "product")
public class Product  extends  BaseEntity{

    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "categoty_id", referencedColumnName = "id")
    private Category category;

    private Double price;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "supplier_id", referencedColumnName = "id")
    private Supplier supplier;

    private Double original_price;


}
