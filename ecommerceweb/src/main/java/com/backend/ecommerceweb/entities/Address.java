package com.backend.ecommerceweb.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "`address`")
@Getter
@Setter
public class Address extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ward_id", referencedColumnName = "id")
    private Ward ward;

    private String address;


}
