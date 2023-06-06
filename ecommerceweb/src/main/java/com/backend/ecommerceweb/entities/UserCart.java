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

    @OneToMany(fetch = FetchType.EAGER)
    private List<Product> products;
    private int productAmount;
    private Long giftId;
    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;


}
