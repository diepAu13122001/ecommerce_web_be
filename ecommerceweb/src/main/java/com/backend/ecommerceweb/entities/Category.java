package com.backend.ecommerceweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Table(name = "category")
public class Category extends BaseEntity {
    private String name;
    private String description;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Product> products;

}
