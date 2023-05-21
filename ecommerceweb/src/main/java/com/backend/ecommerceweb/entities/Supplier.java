package com.backend.ecommerceweb.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "supplier")
public class Supplier extends BaseEntity{

    private String name;
    private int total_order;
    private Long phone;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    private String email;
    private String description;


}
