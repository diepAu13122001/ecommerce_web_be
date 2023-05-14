package com.backend.ecommerceweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
