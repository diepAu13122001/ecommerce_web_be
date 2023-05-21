package com.backend.ecommerceweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Table(name = "category")
@Getter
@Setter
public class Category extends BaseEntity {
    private String name;
    private String description;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Product> products;

}
