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
@Table (
        name = "shipper",
        uniqueConstraints = @UniqueConstraint(
                name = "phone_unique",
                columnNames = "phone"
        )
)
public class Shipper extends BaseEntity {

    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private List<District> districts;

    private String phone;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    private String email;
    private String url_avt;
    private String gender;
    private String orderNumber;

}
