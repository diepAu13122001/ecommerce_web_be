package com.backend.ecommerceweb.entities;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Table(name = "product_image")
public class ProductImage extends BaseEntity {

    private String imgUrl;
    private String imgAlt;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @JsonIgnoreProperties("product_image")
    private Product product;


}
