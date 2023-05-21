package com.backend.ecommerceweb.entities;
import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "product_image")
public class ProductImage extends BaseEntity {


    private String product_img;
    private String product_img_alt;


}
