package com.backend.ecommerceweb.entities;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Table(
        name = "supplier",
        uniqueConstraints = @UniqueConstraint(
                name = "phone_unique",
                columnNames = "phone"
        )
)
public class Supplier extends BaseEntity{

    private String name;
    private int totalOrder;
    private String phone;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    private String email;
    private String description;


}
