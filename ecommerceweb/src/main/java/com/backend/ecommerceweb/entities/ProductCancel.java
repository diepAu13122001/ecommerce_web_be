package com.backend.ecommerceweb.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Data
@Getter
@Setter
@Table(name = "product_cancel")
public class ProductCancel extends BaseEntity{

    private int quantity;
    private Double unit_price;
    private Date created_at;

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;


}
