package com.backend.ecommerceweb.entities;

import javax.persistence.*;

import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Table(name = "user_cart")
public class UserCart extends BaseEntity {

    @OneToMany
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private List<Product> products;
    private int product_amount;
    private Long gift_id;

    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;


}
