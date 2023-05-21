package com.backend.ecommerceweb.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@Table(name = "shipper")
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
