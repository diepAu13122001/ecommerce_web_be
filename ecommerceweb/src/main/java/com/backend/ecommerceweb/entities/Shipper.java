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
public class Shipper extends BaseEntity {

    private String name;

    @OneToMany
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    private List<District> districts;

    private Long phone;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    private String email;
    private String url_avt;
    private String gender;
    private String order_number;

}
