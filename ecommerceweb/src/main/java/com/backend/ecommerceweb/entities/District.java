package com.backend.ecommerceweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "district")
@Getter
@Setter
public class District extends BaseEntity {

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "province_id", referencedColumnName = "id") // thông qua khóa ngoại province_id
    @JsonIgnoreProperties("districts")
    private Province province;


}
