package com.backend.ecommerceweb.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Data
@Table(name = "order")
@Getter
@Setter
public class Order extends BaseEntity {

    private Date order_date;
    private Date delivery_date;
    private PaymentMethod payment_method;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    private Boolean is_delivery;

}
