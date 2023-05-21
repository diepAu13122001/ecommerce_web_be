package com.backend.ecommerceweb.entities;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Table(name = "`order_detail`")
@Getter
@Setter
public class OrderDetail extends BaseEntity{

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    private Double quantity;

    private Long into_money;

}
