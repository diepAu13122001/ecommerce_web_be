package com.backend.ecommerceweb.model.dtos.product;

import com.backend.ecommerceweb.entities.ProductImage;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ProductImageDTO {
    private String imgUrl;
    private String imgAlt;
    private Long productId;

    public ProductImage toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        ProductImage productImage = modelMapper.map(this, ProductImage.class);
        return productImage;
    }

}
