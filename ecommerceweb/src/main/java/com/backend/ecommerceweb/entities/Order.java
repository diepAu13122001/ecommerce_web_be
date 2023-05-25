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
@Table(name = "order")
public class Order extends BaseEntity {

    private Date order_date;
    private Date delivery_date;
    private Date update_date;
    private String order_status;
    private PaymentMethod payment_method;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private User created_user;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private User updated_user;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    private Boolean is_delivered;

    @ManyToOne
    @JoinColumn(name="shipper_id", referencedColumnName = "id")
    private Shipper shipper;

}
