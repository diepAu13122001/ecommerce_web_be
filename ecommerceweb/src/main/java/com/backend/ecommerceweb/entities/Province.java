package com.backend.ecommerceweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@Table(name = "province")
public class Province extends BaseEntity{


    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id", referencedColumnName = "id")
    @JsonIgnoreProperties("province")
    private List<District> districts;
}
