package com.backend.ecommerceweb.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "`ward`")
@Getter
@Setter
public class Ward extends BaseEntity {

    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    private District district;



}
