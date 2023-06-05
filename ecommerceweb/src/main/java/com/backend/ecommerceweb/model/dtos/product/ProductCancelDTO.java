package com.backend.ecommerceweb.model.dtos.product;

import com.backend.ecommerceweb.entities.Address;
import com.backend.ecommerceweb.entities.ProductCancel;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.Date;

@Data
public class ProductCancelDTO {
    private int quantity;
    private Double unitPrice;
    private Long productId;

    public ProductCancel toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        ProductCancel productCancel = modelMapper.map(this, ProductCancel.class);
        return productCancel;
    }

}
