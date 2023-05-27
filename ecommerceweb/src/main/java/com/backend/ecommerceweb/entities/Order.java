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

    private Date orderedDate;
    private Date deliveredDate;
    private Date updatedDate;
    private String orderStatus;
    private PaymentMethod paymentMethod;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private User createdUser;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private User updatedUser;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    private Boolean isDelivered;

    @ManyToOne
    @JoinColumn(name="shipper_id", referencedColumnName = "id")
    private Shipper shipper;

}
